package com.example.kyly3n4;

public class Model {
    String username, name, email, gender, grup, age, keterangan, is_valid;

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Model(String username, String name, String email, String gender, String grup, String age, String keterangan, String is_valid){
        this.username = username;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.grup = grup;
        this.age = age;
        this.keterangan = keterangan;
        this.is_valid = is_valid;
    }

    public String getUsername() { return getUsername(); }

    public void setUsername(String username) { this.username = username; }

    public String getNama() {
        return name;
    }

    public void setNama(String name) {
        this.name = name;
    }

    public String getEmail() { return getEmail(); }

    public void setEmail(String email) { this.email= email; }

    public String getJenis_kelamin() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKondisi_kesehatan (){ return grup; }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getPersentase_kondisi() {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }
}