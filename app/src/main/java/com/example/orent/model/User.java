package com.example.orent.model;


public class User {
    public String nama;
    public String email;
    public String image;
    public String no;

    public User() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(String email, String nama, String no) {
        this.nama = nama;
        this.email = email;
        this.no = no;
    }

    public User(String email, String nama, String image, String no) {
        this.nama = nama;
        this.email = email;
        this.image = image;
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getnama() {
        return nama;
    }

    public void setnama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
