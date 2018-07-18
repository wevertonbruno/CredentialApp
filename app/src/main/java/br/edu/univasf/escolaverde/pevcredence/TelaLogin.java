package br.edu.univasf.escolaverde.pevcredence;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaLogin extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView user = (TextView) findViewById(R.id.tUsuario);
                TextView password = (TextView) findViewById(R.id.tSenha);
                String login = user.getText().toString();
                String senha = password.getText().toString();
                if(login.equals("admin") && senha.equals("admin")){
                    Intent intent = new Intent(getContext(), TelaCategoria.class);
                    startActivity(intent);
                }else{
                    alert("Usuario e/ou Senha incorreto(s)!");
                }
            }
        });
    }

    private Context getContext() {
        return this;
    }

    private void alert(String s) {
        Toast.makeText(this, s,Toast.LENGTH_SHORT).show();
    }
}
