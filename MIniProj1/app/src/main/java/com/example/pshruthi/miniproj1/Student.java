package com.example.pshruthi.miniproj1;

public class Student {
    public String id;
    public String email;
    public String comp;
    public String name;
    public String branch;
    public String resume;
    public String tenth;
    public String puc;
    public String degree;
    public String pg;
    private String others;

    public Student() {
    }

    public Student(String id, String email, String comp, String name, String branch, String resume, String tenth, String puc, String degree, String pg, String others) {
        this.id = id;
        this.email=email;
        this.comp = comp;
        this.name = name;
        this.branch = branch;
        this.resume = resume;
        this.tenth = tenth;
        this.puc = puc;
        this.degree = degree;
        this.pg = pg;
        this.others = others;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTenth() {
        return tenth;
    }

    public void setTenth(String tenth) {
        this.tenth = tenth;
    }

    public String getPuc() {
        return puc;
    }

    public void setPuc(String puc) {
        this.puc = puc;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
