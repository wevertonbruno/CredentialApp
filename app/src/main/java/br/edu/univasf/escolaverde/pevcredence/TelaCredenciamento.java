package br.edu.univasf.escolaverde.pevcredence;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class TelaCredenciamento extends DebugActivity {
    Button scanButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_credenciamento);
        String title = getIntent().getStringExtra("TITLE");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle(title);

        scanButton = (Button) findViewById(R.id.btScan);
        final Activity activity = this; //salvando a activity atual para passar como parametro no IntentIntegrator

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator itIntegrator = new IntentIntegrator(activity); //Instanciando integrator
                itIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES); // setando o tipo de leitura para qrcode
                itIntegrator.setPrompt("QRCode Scan"); //Nome que será mostrado na tela da camera
                itIntegrator.setCameraId(0); //Qual camera será usada 0-traseira 1-frontal
                itIntegrator.initiateScan(); //Iniciando o scan
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Deve-se implementar esse método para receber os dados.
        //IntentResult recebe a resposta do integrador
        IntentResult itResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        //
        if(itResult != null){
            if(itResult.getContents() != null){
                alert(itResult.getContents());
            }else{
                alert("Scan cancelado pelo usuário!");
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String str){
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Context getContext() {
        return this;
    }
}
