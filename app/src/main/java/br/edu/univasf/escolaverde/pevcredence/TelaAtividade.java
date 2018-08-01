package br.edu.univasf.escolaverde.pevcredence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaAtividade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_atividade);

        String textoDaTela = getIntent().getStringExtra("textoTela");
        this.setTitle(textoDaTela);
    }
}
