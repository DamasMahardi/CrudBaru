package com.example.crudbaru.model;

public class Karyawan {
    private String id, name, jabatan,alamat,email,telephone;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getJabatan(){
        return jabatan;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getEmail(){
        return email;
    }

    public String getTelephone(){
        return  telephone;
    }

}
