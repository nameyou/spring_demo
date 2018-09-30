package com.lee.demo.service.impl;

import com.lee.demo.service.IUserService;

import java.util.*;

public class UserServiceImpl2 implements IUserService {


    private List<String> list;
    private Map<String, Object> map;
    private String[] arr;
    private Set<String> set;
    private Properties pro;

    public Properties getPro() {
        return pro;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }

    public UserServiceImpl2() {
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "UserServiceImpl2{" +
                "list=" + list +
                ", map=" + map +
                ", arr=" + Arrays.toString(arr) +
                ", set=" + set +
                ", pro=" + pro +
                '}';
    }

    public void testDI() {

    }
}
