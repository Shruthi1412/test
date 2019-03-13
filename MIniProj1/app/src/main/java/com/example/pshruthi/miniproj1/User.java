package com.example.pshruthi.miniproj1;

public class User {
    private String id;
    private String name;
    private String desc;
    private String elig;
    private String schedule;

    public User() {
    }

    public User(String id, String name, String desc, String elig, String schedule) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.elig = elig;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getElig() {
        return elig;
    }

    public void setElig(String elig) {
        this.elig = elig;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
