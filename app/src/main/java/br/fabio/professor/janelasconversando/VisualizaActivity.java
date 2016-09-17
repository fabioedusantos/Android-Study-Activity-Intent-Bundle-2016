package br.fabio.professor.janelasconversando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VisualizaActivity extends AppCompatActivity {

    private String nome;
    private String endereco;
    private String email;

    private TextView txtNome;
    private TextView txtEndereco;
    private TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza);

        //pegamos todos os extras enviados da janela anterior
        Bundle extras = getIntent().getExtras();
        nome = extras.getString("nome");
        endereco = extras.getString("endereco");
        email = extras.getString("email");

        txtNome = (TextView) findViewById(R.id.lbl_nome);
        txtEndereco = (TextView) findViewById(R.id.lbl_endereco);
        txtEmail = (TextView) findViewById(R.id.lbl_email);

        txtNome.setText(nome);
        txtEndereco.setText(endereco);
        txtEmail.setText(email);
    }
}
