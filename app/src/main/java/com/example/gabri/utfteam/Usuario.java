package com.example.gabri.utfteam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class Usuario {

    private String nome;
    private String email;
    private int cpf;
    private String senha;
    private char sexo;
    private Context context;

    public Usuario(Context context){
        this.context = context;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

 /*   public ArrayList<Usuario> getUsuarios(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((cursor != null) && (!cursor.isClosed()))
                cursor.close();
            if(sqLiteDatabase != null)
                sqLiteDatabase.close();
            if(dbHelper != null)
                dbHelper.close();
        }

        return usuarios;
    }*/
}
