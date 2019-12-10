package com.example.gabri.utfteam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        else
            return "Erro ao cadastrar";
    }
}
