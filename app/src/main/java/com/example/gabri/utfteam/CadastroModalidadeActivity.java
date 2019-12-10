package com.example.gabri.utfteam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class CadastroModalidadeActivity extends Activity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_modalidade);

        listView = (ListView) findViewById(R.id.listViewId);
    }
}
