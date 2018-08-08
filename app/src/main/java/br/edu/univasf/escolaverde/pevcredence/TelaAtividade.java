package br.edu.univasf.escolaverde.pevcredence;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaAtividade extends DebugActivity{
    String textoDaTela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atividade);
        textoDaTela = getIntent().getStringExtra("textoTela");
        this.setTitle(textoDaTela);

        ListView listaDeAtividades = (ListView) findViewById(R.id.listAtividades);
        //Array de strings de exemplo. Deverá ser trocada pela lista do banco de dados.
        
        String[] exemplos = new String[]{"Atv1", "Atv2", "Atv3", "Atv4"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemplos);
        listaDeAtividades.setAdapter(adapter1);

        listaDeAtividades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent(getContext(), TelaCredenciamento.class);
                intent.putExtra("TITLE", title);
                startActivity(intent);
            }
        });

    }

    protected void onResume() {
        super.onResume();
        this.setTitle(textoDaTela);
    }

    public Context getContext() {
        return this;
    }
}
