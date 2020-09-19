package com.example.imageuploadingfirebase;

public class User {
    private String name, moblieno,filelocation;

    public User(){

    }

    public User(String name, String moblieno, String filelocation) {
        this.name = name;
        this.moblieno = moblieno;
        this.filelocation = filelocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoblieno() {
        return moblieno;
    }

    public void setMoblieno(String moblieno) {
        this.moblieno = moblieno;
    }

    public String getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String filelocation) {
        this.filelocation = filelocation;
    }
}
