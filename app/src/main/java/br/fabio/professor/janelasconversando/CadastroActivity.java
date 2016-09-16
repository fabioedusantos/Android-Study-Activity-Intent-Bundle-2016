package br.fabio.professor.janelasconversando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText nome;
    private EditText endereco;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.txt_nome);
        endereco = (EditText) findViewById(R.id.txt_endereco);
        email = (EditText) findViewById(R.id.txt_email);
    }

    public void salvar(View v){
        Intent i = new Intent(CadastroActivity.this, VisualizaActivity.class);
        i.putExtra("nome", nome.getText().toString());
        i.putExtra("endereco", endereco.getText().toString());
        i.putExtra("email", email.getText().toString());
        startActivity(i);
    }
}
