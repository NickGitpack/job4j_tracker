package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String name;
    private String group;
    private Date enter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getEnter() {
        return enter;
    }

    public void setEnter(Date enter) {
        this.enter = enter;
    }
}