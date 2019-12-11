package com.example.gabri.utfteam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    Created By Vinicius Ribeiro on 09/12/19
*/

public class DBHelper extends SQLiteOpenHelper {

    private static final String BDNAME = "appBD.db";
    private static final String TABELA = "usuarios";
    private static final String NOME_TABLE = "nome";
    private static final String EMAIL_TABLE = "email";
    private static final String CPF_TABLE = "cpf";
    private static final String SEXO_TABLE = "sexo";
    private static final String RA_TABLE = "ra";
    private static final String SENHA_TABLE = "senha";
    private static final int VERSAO = 1;

    private static final String MUAY_THAI_TABELA = "alunos_muay_thai";
    private static final String JIU_JITSU_TABELA = "alunos_jiu_jitsu";
    private static final String TAEKWONDO_TABELA = "alunos_taekwondo";
    private static final String KARATE_TABELA = "alunos_karate";

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

        sqLiteDatabase.execSQL(criaTabela(MUAY_THAI_TABELA)); //Retorno da função criaTabela() é a Query para criar a tabela
        sqLiteDatabase.execSQL(criaTabela(JIU_JITSU_TABELA));
        sqLiteDatabase.execSQL(criaTabela(TAEKWONDO_TABELA));
        sqLiteDatabase.execSQL(criaTabela(KARATE_TABELA));

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion,int newVersion){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+MUAY_THAI_TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+JIU_JITSU_TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TAEKWONDO_TABELA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+KARATE_TABELA);
        onCreate(sqLiteDatabase);
    }
    public String criaTabela(String tabela){
        String sql = "CREATE TABLE IF NOT EXISTS "+ tabela + "( "
                + CPF_TABLE + " TEXT PRIMARY KEY, "
                + NOME_TABLE + " TEXT, "
                + "FOREIGN KEY (" + CPF_TABLE + ") REFERENCES " + TABELA + "(" + CPF_TABLE + ") "
                + " );";
        return sql;
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

    public static String getMuayThaiTabela() {
        return MUAY_THAI_TABELA;
    }

    public static String getJiuJitsuTabela() {
        return JIU_JITSU_TABELA;
    }

    public static String getTaekwondoTabela() {
        return TAEKWONDO_TABELA;
    }

    public static String getKarateTabela() {
        return KARATE_TABELA;
    }
}
