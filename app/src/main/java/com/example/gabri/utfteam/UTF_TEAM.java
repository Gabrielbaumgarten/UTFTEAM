package com.example.gabri.utfteam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UTF_TEAM extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

//        configureBotaoInicial();
    }
    /*private void configureBotaoInicial(){
        Button botaoInicial = (Button) findViewById(R.id.botao_logo_inicial);
        botaoInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UTF_TEAM.this, Login_activity.class));
            }
        });
    }*/
}
