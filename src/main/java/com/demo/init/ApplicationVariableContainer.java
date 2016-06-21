package com.demo.init;


import com.demo.model.Permission;
import com.demo.util.JsonMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * Created by xinxingegeya on 16/1/10.
 */
@Component
public class ApplicationVariableContainer implements InitializingBean {

    private List<Menu> menuList;
    private List<Permission> artistOperationList;

    @Override
    public void afterPropertiesSet() throws Exception {
        JsonMapper mapper = JsonMapper.nonNullMapper();

        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource menuResource = resourcePatternResolver
            .getResource("classpath:menu/menu.json");
        String menuPath = menuResource.getFile().getPath();
//        menuPath=menuPath.replaceAll("%5cmenu%5cmenu","menu/menu");
        BufferedReader menuBufferedReader = new BufferedReader(
            new FileReader(menuPath));
        StringBuilder menuJsonStr = new StringBuilder();
        String line;
        while ((line = menuBufferedReader.readLine()) != null) {
            menuJsonStr.append(line);
        }
        menuBufferedReader.close();
        menuList = mapper.fromJson(menuJsonStr.toString(),
            mapper.createCollectionType(List.class, Menu.class));
        Resource operationResource = resourcePatternResolver
            .getResource("classpath:menu/operation.json");
        String operationPath = operationResource.getFile().getPath();
//        operationPath=operationPath.replaceAll("%5cmenu%5coperation","menu/operation");
        BufferedReader operationBufferedReader = new BufferedReader(
            new FileReader(operationPath));
        StringBuilder json = new StringBuilder();
        while ((line = operationBufferedReader.readLine()) != null) {
            json.append(line);
        }
        operationBufferedReader.close();
        artistOperationList = mapper.fromJson(json.toString(),
            mapper.createCollectionType(List.class, Permission.class));
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Permission> getArtistOperationList() {
        return artistOperationList;
    }

    public void setArtistOperationList(List<Permission> artistOperationList) {
        this.artistOperationList = artistOperationList;
    }
}
