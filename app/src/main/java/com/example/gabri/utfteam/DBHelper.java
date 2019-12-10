package com.example.gabri.utfteam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String BDNAME = "usersBD.db";
    private static final String TABELA = "usuarios";
    private static final String NOME_TABLE = "nome";
    private static final String EMAIL_TABLE = "email";
    private static final String CPF_TABLE = "cpf";
    private static final String SEXO_TABLE = "sexo";
    private static final String RA_TABLE = "ra";
    private static final String SENHA_TABLE = "senha";
    private static final int VERSAO = 1;

    public DBHelper(Context context){
        super(context, BDNAME, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA + "( "
                + NOME_TABLE + " TEXT, "
                + EMAIL_TABLE + " TEXT,"
                + CPF_TABLE + " TEXT PRIMARY KEY,"
                + SEXO_TABLE + " TEXT,"
                + RA_TABLE + " TEXT,"
                + SENHA_TABLE + " TEXT"
                + " );";
        sqLiteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion,int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(sqLiteDatabase);
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getNomeTable() {
        return NOME_TABLE;
    }

    public static String getEmailTable() {
        return EMAIL_TABLE;
    }

    public static String getCpfTable() {
        return CPF_TABLE;
    }

    public static String getSexoTable() {
        return SEXO_TABLE;
    }

    public static String getRaTable() {
        return RA_TABLE;
    }

    public static String getSenhaTable() {
        return SENHA_TABLE;
    }
}
