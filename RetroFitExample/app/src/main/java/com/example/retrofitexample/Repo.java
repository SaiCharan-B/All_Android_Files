package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Repo {

    private String name;
    @SerializedName("full_name")
    private String fullname;

    Repo(String name,String fullname)
    {
        this.name = name;
        this.fullname = fullname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
