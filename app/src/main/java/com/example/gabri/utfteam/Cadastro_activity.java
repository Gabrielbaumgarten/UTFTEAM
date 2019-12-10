package com.example.gabri.utfteam;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class Cadastro_activity extends Activity {

    private Button cadastrar;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        cadastrar = (Button) findViewById(R.id.button_finalizar_cadastro);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
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

    public void cadastrarUsuario() {

        DBController cadastro = new DBController(getBaseContext());
        EditText nome = (EditText) findViewById(R.id.campo_nome);
        EditText email = (EditText) findViewById(R.id.campo_email);
        EditText cpf = (EditText) findViewById(R.id.campo_cpf);
        EditText ra = (EditText) findViewById(R.id.campo_registro_acadmico);
        EditText senha1 = (EditText) findViewById(R.id.campo_senha1);
        EditText senha2 = (EditText) findViewById(R.id.campo_senha2);

        String UserNome = nome.getText().toString();
        String UserEmail = email.getText().toString();
        String UserCpf = cpf.getText().toString();
        String UserRa = ra.getText().toString();
        String UserSexo = sexoEscolhido();
        String UserSenha1 = senha1.getText().toString();
        String UserSenha2 = senha2.getText().toString();
        String resultado;

        if (!(UserSenha1.equals(UserSenha2))){
            Toast.makeText(getApplicationContext(), "As senhas não coincidem.", Toast.LENGTH_SHORT).show();
            return;
        }
       if(UserSexo == null){
           Toast.makeText(getApplicationContext(),"Selecione seu sexo.",Toast.LENGTH_SHORT).show();
            return;
       }
       if ((UserNome == null) || (UserEmail == null) || (UserCpf == null)){
           Toast.makeText(getApplicationContext(),"Preencha todos os campos.",Toast.LENGTH_SHORT).show();
            return;
       }
        resultado = cadastro.inserirDados(UserNome,UserEmail,UserCpf,UserSexo,UserRa,UserSenha1);

        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();

    }
    public String sexoEscolhido(){
        RadioButton sexoEscolhido;
        int idSexo = radioGroup.getCheckedRadioButtonId();
        if (idSexo > 0){
            sexoEscolhido = (RadioButton) findViewById(idSexo);
            return  sexoEscolhido.getText().toString();
        }
        return null;
    }

}
