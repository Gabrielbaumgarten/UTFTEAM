package com.example.gabri.utfteam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
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
        super.onStart();   setContentView(R.layout.tela_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.tela_login);
        configureBotaoVoltar();
        configureBotaoCadastrar();
        configureBotaoLogin();
    }

    public void configureBotaoVoltar(){
        ImageButton botaoVoltar = (ImageButton) findViewById(R.id.botao_voltar_login);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void configureBotaoCadastrar(){
        ImageButton botaoCadastrar = (ImageButton) findViewById(R.id.botao_cadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_activity.this, Cadastro_activity.class));
            }
        });
    }

    public void configureBotaoLogin(){
        Button botaoLogin = (Button) findViewById(R.id.botao_luvas_boxe_login);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText campoUser = (EditText) findViewById(R.id.login_usuario);
                EditText campoSenha = (EditText) findViewById(R.id.login_senha);
                DBController db = new DBController(getBaseContext());

                String user = campoUser.getText().toString();
                String senha = campoSenha.getText().toString();

                if(db.validarLogin(user,senha)){

                    Intent intent = new Intent(Login_activity.this, TelaPrincipalActivity.class);
                    Usuario usuario = new Usuario();
                    usuario = db.carregaUsuario(user);
                    intent.putExtra("objeto",usuario);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos.",Toast.LENGTH_LONG).show();

          }
        });
    }
}
