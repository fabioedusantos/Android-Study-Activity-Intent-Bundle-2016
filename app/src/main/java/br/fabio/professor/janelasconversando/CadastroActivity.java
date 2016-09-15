package br.fabio.professor.janelasconversando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
