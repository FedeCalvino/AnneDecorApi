package com.example.sistemaannedecor2.Dto;

public class DtoUsuario {
    int Id;
    String Mail;
    String Password;

    public DtoUsuario(String Mail, String Password) {
        this.Mail = Mail;
        this.Password = Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public String getMail() {
        return Mail;
    }

    public String getPassword() {
        return Password;
    }
}
