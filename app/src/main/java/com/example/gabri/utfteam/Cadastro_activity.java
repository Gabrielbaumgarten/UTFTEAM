package com.example.gabri.utfteam;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Cadastro_activity extends Activity {

    private String nome;
    private String email;
    private int cpf;
    private String senha;
    private char sexo;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureBotaoVoltar();
    }

    public void configureBotaoVoltar(){
        ImageButton botaoVoltar = (ImageButton) findViewById(R.id.botao_voltar_cadastro);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void botaoCadastrar(){

    }
    public boolean cadastrarUsuario(){
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql = "";
            sql = "INSERT INTO pessoa (nome,email,cpf,sexo,senha) VALUES (?,?,?,?,?)";

            sqLiteDatabase.beginTransaction();
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1,nome);
            sqLiteStatement.bindString(2,email);
            sqLiteStatement.bindString(3,String.valueOf(cpf));
            sqLiteStatement.bindString(4,String.valueOf(sexo));
            sqLiteStatement.bindString(5,senha);
            sqLiteStatement.executeInsert();

            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
        }catch (Exception e){
            e.printStackTrace();
            sqLiteDatabase.endTransaction();
            return false;
        }finally {
            if(sqLiteDatabase != null)
                sqLiteDatabase.close();
            if(dbHelper != null)
                dbHelper.close();
            return true;
        }
    }
}
