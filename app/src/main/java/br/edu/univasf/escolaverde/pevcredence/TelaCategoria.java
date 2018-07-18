package br.edu.univasf.escolaverde.pevcredence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaCategoria extends DebugActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_categoria);
        Button btMinicurso      = (Button) findViewById(R.id.btMinicurso);
        Button btConferencia    = (Button) findViewById(R.id.btConferencia);
        Button btOficina        = (Button) findViewById(R.id.btOficina);
        Button btMesa           = (Button) findViewById(R.id.btMesa);/**/

        btMinicurso.setOnClickListener(this);
        btConferencia.setOnClickListener(this);
        btMesa.setOnClickListener(this);
        btOficina.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btMinicurso:
                alert("Minicurso aberto!");
                /*Ação aqui*/
                break;
            case R.id.btConferencia:
                alert("Conferencia aberto!");
                /*Ação aqui*/
                break;
            case R.id.btOficina:
                alert("Oficina aberto!");
                /*Ação aqui*/
                break;
            case R.id.btMesa:
                alert("Mesa aberto!");
                /*Ação aqui*/
                break;
            default:
                break;
        }
    }

    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
