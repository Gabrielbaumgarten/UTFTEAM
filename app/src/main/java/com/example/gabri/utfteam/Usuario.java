package com.example.gabri.utfteam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.util.ArrayList;


public class Usuario implements Serializable {

    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String sexo;
    private String ra;
    private Context context;

    public Usuario() {

    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

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

    public String  getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void carregaUsuario(String user){



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
