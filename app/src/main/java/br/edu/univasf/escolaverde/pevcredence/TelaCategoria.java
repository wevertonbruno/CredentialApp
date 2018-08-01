package br.edu.univasf.escolaverde.pevcredence;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class TelaCategoria extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categoria);

        ListView listaDeCategorias = (ListView) findViewById(R.id.listCategorias);
        String[] opcoes = new String[]{"Minicursos", "Conferências", "Oficinas", "Mesas"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoes);
        listaDeCategorias.setAdapter(adapter);

        listaDeCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // alert("Clicou em: " + position);

                String nome = parent.getItemAtPosition(position).toString(); //pegando nome do item na posição clicada
                Intent intent = new Intent(getContext(), TelaAtividade.class); //instanciando o intent

                switch(position){
                    case 0:
                        intent.putExtra("textoTela", nome); //passando dados para a nova tela
                        startActivity(intent); //iniciando o intent
                        break;
                    case 1:
                        intent.putExtra("textoTela", nome);
                        startActivity(intent);

                        break;
                    case 2:
                        intent.putExtra("textoTela", nome);
                        startActivity(intent);

                        break;
                    case 3:
                        intent.putExtra("textoTela", nome);
                        startActivity(intent);

                        break;
                    default:
                        break;
                }
            }
        });

        /**

        Button btMinicurso      = (Button) findViewById(R.id.btMinicurso);
        Button btConferencia    = (Button) findViewById(R.id.btConferencia);
        Button btOficina        = (Button) findViewById(R.id.btOficina);
        Button btMesa           = (Button) findViewById(R.id.btMesa);

        btMinicurso.setOnClickListener(this);
        btConferencia.setOnClickListener(this);
        btMesa.setOnClickListener(this);
        btOficina.setOnClickListener(this);
         */

    }

    /**
    public void onClick(View view){
        Intent intent = new Intent(getContext(), TelaAtividade.class);
        switch(view.getId()){
            case R.id.btMinicurso:
                intent.putExtra("textoTela", "Minicursos");
                startActivity(intent);
                //alert("Minicurso aberto!");

                break;
            case R.id.btConferencia:
                intent.putExtra("textoTela", "Conferências");
                startActivity(intent);
                alert("Conferencia aberto!");

                break;
            case R.id.btOficina:
                intent.putExtra("textoTela", "Oficinas");
                startActivity(intent);
                alert("Oficina aberto!");

                break;
            case R.id.btMesa:
                intent.putExtra("textoTela", "Mesas");
                startActivity(intent);
                alert("Mesa aberto!");

                break;
            default:
                break;
        }
    }
    */

    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    public Context getContext() {
        return this;
    }
}
