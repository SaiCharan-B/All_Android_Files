package com.example.registerandloginmodule;

public class User {

    private String name,email,uname,pass;
    public User(String name, String email, String uname, String pass) {
        this.name = name;
        this.email = email;
        this.uname= uname;
        this.pass = pass;
    }
    public User()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
