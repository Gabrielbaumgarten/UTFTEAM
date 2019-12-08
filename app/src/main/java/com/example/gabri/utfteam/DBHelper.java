package com.example.gabri.utfteam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static String BDname = "sqliteBD.db";
    private static int VERSAO = 1;

    public DBHelper(Context context){
        super(context, BDname, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS [pessoa] (\n" +
                        "[nome] VARCHAR(60)  NOT NULL,\n" +
                        "[email] VARCHAR(60)  UNIQUE NOT NULL,\n" +
                        "[cpf] INTEGER(11)  UNIQUE NOT NULL,\n" +
                        "[sexo] vaRCHAR(1)  NULL,\n" +
                        "[senha] VARCHAR(60)  NOT NULL\n" +
                        ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS[aluno] (\n" +
                "[ra] INTEGER  NOT NULL PRIMARY KEY,\n" +
                "[cpf] INTEGER  UNIQUE NOT NULL,\n" +
                "FOREIGN KEY ([cpf]) REFERENCES pessoa([CPF])\n" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
