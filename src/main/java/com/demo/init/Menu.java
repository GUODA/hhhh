package com.demo.init;

import com.demo.model.Permission;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: K
 * Date: 13-10-7
 * Time: 下午3:47
 * 菜单表
 */

public class Menu implements Serializable {
    private Integer id;

    private String name;
    private String text;
    private String url;
    private int sort;
    private Menu parentMenu;
    private String icon;
    private String resource;
    private List<Menu> subMenu = new ArrayList<>();
    private List<Permission> perms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<Permission> getPerms() {
        return perms;
    }

    public void setPerms(List<Permission> perms) {
        this.perms = perms;
    }

    public boolean hasPermission() {
        return this.perms != null && this.perms.size() > 0 ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Menu menu = (Menu) o;
        return Objects.equal(name, menu.name) && Objects.equal(text, menu.text)
            && Objects.equal(url, menu.url) && Objects.equal(icon, menu.icon)
            && Objects.equal(resource, menu.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, text, url, icon, resource);
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name='" + name + '\'' + ", text='"
            + text + '\'' + ", resource='" + resource + '\'' + ", url='" + url
            + '\'' + '}';
    }
}
