package com.example.gabri.utfteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CadastroModalidadeActivity extends Activity {

    private ListView listView;
    private String [] modalidades = {
            "Muay Thai", "Jiu Jitsu",
            "Taekwondo", "Karatê"
    };
    private Button alunosMatriculados;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_modalidade);
        Intent i = getIntent();
        usuario = (Usuario) i.getSerializableExtra("objeto");

        listView = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                modalidades
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DBController db = new DBController(getBaseContext());
                boolean resultado = false;
                switch (position){
                    case 0:
                        resultado = db.cadastraModalidade(usuario.getCpf(),usuario.getNome(),DBHelper.getMuayThaiTabela());
                        break;
                    case 1:
                        resultado = db.cadastraModalidade(usuario.getCpf(),usuario.getNome(),DBHelper.getJiuJitsuTabela());
                        break;
                    case 2:
                        resultado = db.cadastraModalidade(usuario.getCpf(),usuario.getNome(),DBHelper.getTaekwondoTabela());
                        break;
                    case 3:
                        resultado = db.cadastraModalidade(usuario.getCpf(),usuario.getNome(),DBHelper.getKarateTabela());
                        break;

                }
                if(resultado)
                    Toast.makeText(getApplicationContext(),"Cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Falha em cadastrar.", Toast.LENGTH_SHORT).show();
            }
        });
        alunosMatriculados = (Button) findViewById(R.id.btnConsultaAlunos);
        alunosMatriculados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CadastroModalidadeActivity.this, consultaAlunos.class));
            }
        });
    }
}
