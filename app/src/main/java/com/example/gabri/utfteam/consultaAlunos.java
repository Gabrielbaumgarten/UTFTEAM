package com.example.gabri.utfteam;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class consultaAlunos extends AppCompatActivity {
    DBHelper dbHelper;
    DBController dbController;

    ListView alunosList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_alunos);
        dbController = new DBController(this);
        listItem = new ArrayList<>();
        alunosList = findViewById(R.id.alunosListView);
        viewData();

        alunosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = alunosList.getItemAtPosition(position).toString();
                Toast.makeText(consultaAlunos.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void viewData() {
        Cursor cursor = dbController.viewData();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Sem entradas para mostrar", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                listItem.add(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.getNomeTable())));
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);
            alunosList.setAdapter(adapter);
        }
    }
}
