package com.example.gabri.utfteam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/*
    Created By Vinicius Ribeiro on 09/12/19
*/
public class DBController {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public DBController (Context context){
        dbHelper = new DBHelper(context);
    }


    public String inserirDados (String nome, String email, String cpf, String sexo, String ra, String senha){
        ContentValues valores;

        db = dbHelper.getWritableDatabase();
        valores = new ContentValues();
        long resultado;
        valores.put(DBHelper.getNomeTable(), nome);
        valores.put(DBHelper.getEmailTable(), email);
        valores.put(DBHelper.getCpfTable(), cpf);
        valores.put(DBHelper.getSexoTable(), sexo);
        valores.put(DBHelper.getRaTable(), ra);
        valores.put(DBHelper.getSenhaTable(), senha);

        resultado = db.insert(DBHelper.getTABELA(),null, valores);
        db.close();

        if(resultado != -1)
            return "Cadastrado com sucesso";

        return "Erro ao cadastrar";
    }
    public boolean validarLogin(String user, String senha){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE cpf=? AND senha =?", new String[]{user,senha});
        if(cursor.getCount() > 0) {
            db.close();
            return true;
        }
        cursor = db.rawQuery("SELECT * FROM usuarios WHERE ra=? AND senha =?", new String[]{user,senha});
        if(cursor.getCount() > 0) {
            db.close();
            return true;
        }
        db.close();
        cursor.close();
        return false;

    }
    public Usuario carregaUsuario(String user){
        Usuario usuario = new Usuario();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE cpf=? OR ra=?", new String[]{user,user});
        cursor.moveToFirst();

        usuario.setNome(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getNomeTable())));
        usuario.setCpf(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getCpfTable())));
        usuario.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getEmailTable())));
        usuario.setSexo(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getSexoTable())));
        usuario.setRa(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getRaTable())));

        cursor.close();
        db.close();
        return usuario;
    }
    public boolean cadastraModalidade(String cpf, String nome, String tabela){
        ContentValues valores;
        valores = new ContentValues();
        db = dbHelper.getWritableDatabase();

        valores.put(DBHelper.getCpfTable(),cpf);
        valores.put(DBHelper.getNomeTable(),nome);

        long sucesso = db.insert(tabela,null,valores);
        if (sucesso == -1)
            return false;
        return true;



    }
}
