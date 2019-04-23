package com.codeup.adlister;

public class Config {
    private String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String user =  "adlister_admin";
    private  String password =  "bosox001";

    public String getUrl(){
        return url;
    }
    public String getUser() { return user; }
    public String getPassword() {
        return password;
    }
}
