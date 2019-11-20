package com.example.gabri.utfteam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class TelaPrincipalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        navigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        navigationView.setOnNavigationItemSelectedListener(this);

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
