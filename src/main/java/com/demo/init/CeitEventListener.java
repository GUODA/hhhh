package com.demo.init;

import com.demo.dao.PermissionMapper;
import com.demo.dao.RoleMapper;
import com.demo.dao.UserMapper;
import com.demo.model.Permission;
import com.demo.model.Role;
import com.demo.model.User;
import com.demo.model.UserMessage;
import com.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 项目初始化
 */

@Component
@Transactional
public class CeitEventListener
        implements ApplicationListener<ContextRefreshedEvent> {
    public static final int USER_CREATE_BY_SYSTEM_SINGLE = 1;
    private static Logger logger = LoggerFactory
        .getLogger(CeitEventListener.class);
    @Autowired
    @Qualifier("roleMapper")
    private RoleMapper roleDAO;
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userDAO;
    @Autowired
    @Qualifier("permissionMapper")
    private PermissionMapper permissionDAO;
    @Value("#{configurer['ydd.admin.username']}")
    private String defaultAdmin;
    @Value("#{configurer['ydd.admin.super.role']}")
    private String defaultSuperRole;
    @Value("#{configurer['ydd.admin.common.role']}")
    private String defaultCommonRole;
    @Value("#{configurer['ydd.admin.password']}")
    private String defaultPassword;
    @Autowired
    private UserService userService;
    @Value("#{configurer['ydd.admin.init']}")
    private boolean isInit;

    @Autowired
    private ApplicationVariableContainer container;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CeitEventListener.logger.info("Event Occurred : " + event);
        //root of context
        if (event.getApplicationContext().getParent() == null) {
            try {
                if (isInit) {
                    this.initAdmin();
                    logger.info("the system init success");
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("the system init failed");
            }
        }
    }


/* *
     * 初始化菜单
     *
     * @throws IOException
     */

    public void initMenu() throws Exception {
        List<Menu> menus = container.getMenuList();
        for (Menu m : menus) {
            if (StringUtils.isBlank(m.getResource())) {
                throw new RuntimeException(
                    "the resource of menu[" + m.getName() + "] is blank");
            }
            initPermission(m);
            if (m.getSubMenu() != null && !m.getSubMenu().isEmpty()) {
                for (Menu child : m.getSubMenu()) {
                    if (StringUtils.isBlank(m.getResource())) {
                        throw new RuntimeException("the resource of menu["
                            + m.getName() + "] is blank");
                    }
                    child.setParentMenu(m);
                    initPermission(child);
                }
            }
        }
    }

    /* *
     * 处理perms节点
     *
     * @param menu
     * @throws Exception
     * */

    public void initPermission(Menu menu) throws Exception {
        if (menu.hasPermission()) {
            for (Permission p : menu.getPerms()) {
                if (StringUtils.isBlank(p.getResourse())) {
                    throw new RuntimeException(
                        "the resource of permission under the menu["
                            + menu.getName() + "] is blank");
                }
                if (!StringUtils.equals(menu.getResource(), p.getResourse())) {
                    throw new RuntimeException(
                        "the resource field of menu and permission must be equal");
                }
                p.setSystemperm(true);
                p.setResourseperm(false);

                Permission targetPermission = this.permissionDAO.getPermission(
                    p.getResourse(), p.getOperation(), p.getInstance(),
                    p.getResourseperm(), p.getSystemperm());
                if (targetPermission == null) {
                    this.permissionDAO.insertSelective(p);
                } else {
                    p.setId(targetPermission.getId());
                    this.permissionDAO.updateByPrimaryKeySelective(p);
                }
            }
        }
    }


    /**
     * 初始化用户和角色
     */

    public void initAdmin() throws Exception {
        Role sa = this.roleDAO.getRoleByName(this.defaultSuperRole);
        if (sa == null) {
            sa = new Role();
            sa.setCreatedate(new Date());
            sa.setIsdelete((byte) 0);
            sa.setRolename(this.defaultSuperRole);
            sa.setDescription(this.defaultSuperRole);
            sa.setSort((long) 1);
            sa.setStatus((byte) 1);
            sa.setSystem((byte) 1);
            this.roleDAO.insertSelective(sa);
        }

        Role ca = this.roleDAO.getRoleByName(this.defaultCommonRole);
        if (ca == null) {
            ca = new Role();
            ca.setCreatedate(new Date());
            ca.setIsdelete((byte) 0);
            ca.setRolename(this.defaultCommonRole);
            ca.setDescription(this.defaultCommonRole);
            ca.setSort((long) 1);
            ca.setStatus((byte) 1);
            ca.setSystem((byte) 1);
            //系统第一次初始化该角色拥有全部系统权限
       /*     Set<Permission> perms = this.permissionDAO.getAllPermissions();
            ca.setPerms(perms);*/
            this.roleDAO.insertSelective(ca);
        }

        User admin = this.userService.findByAccount(this.defaultAdmin);
        if (admin == null) {
            admin = new User();
            admin.setCreateType(USER_CREATE_BY_SYSTEM_SINGLE);
            //管理员默认的角色
          /*  admin.setRoleSet(new HashSet<>(Arrays.asList(sa)));*/
            admin.setAccount(this.defaultAdmin);
            admin.setUsername(this.defaultAdmin);
            admin.setPassword(new Sha1Hash(defaultPassword).toHex());
            UserMessage userMessage = new UserMessage();
            userMessage.setCreateTime(new Date());
            userMessage.setUserId(admin.getId());
//            this.userMessageDao.save(userInfoDetail);
            this.userDAO.insertSelective(admin);
        }
        userDAO.insertRoleUser(userDAO.getUserByAccount(defaultAdmin).getId(),roleDAO.getRoleByName(defaultSuperRole).getId());
    }
}
