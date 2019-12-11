package com.example.gabri.utfteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;
    private TextView mTextMessage;
    private  Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.areaTrabalho, new Menu_fragment()).commit();
        }

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
//        navigationView.getSelectedItemId();
        navigationView.setOnNavigationItemSelectedListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        Intent i = getIntent();
        usuario = (Usuario) i.getSerializableExtra("objeto");
        configureBotaoCadastroModalidade();

        mTextMessage = (TextView) findViewById(R.id.message);
        i = getIntent();
        Usuario usuario = (Usuario) i.getSerializableExtra("objeto");
        String nome = usuario.getNome();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Fragment home_fragment = Home_fragment.newInstance();
                openFragment(home_fragment);
                break;
            case R.id.navigation_grade_horaria:
                Fragment grade_horaria_fragment = Grade_horaria_fragment.newInstance();
                openFragment(grade_horaria_fragment);
                break;
            case R.id.navigation_menu:
                Fragment menu_fragment = Menu_fragment.newInstance();
                openFragment(menu_fragment);
                break;
            case R.id.navigation_perfil:
                Fragment perfil_fragment = Perfil_fragment.newInstance();
                openFragment(perfil_fragment);
                break;
        }
        return false;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.areaTrabalho, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void configureBotaoCadastroModalidade(){
        Button btnCadastrarmodalidade = (Button) findViewById(R.id.botaoCadastrarModalidade);
        btnCadastrarmodalidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalActivity.this, CadastroModalidadeActivity.class);
                intent.putExtra("objeto",usuario);
                startActivity(intent);
            }
        });
    }
}
