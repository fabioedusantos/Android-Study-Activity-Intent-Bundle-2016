package br.fabio.professor.janelasconversando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VisualizaActivity extends AppCompatActivity {

    private String nome;
    private String endereco;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza);

        //pegamos todos os extras enviados da janela anterior
        Bundle extras = getIntent().getExtras();
        nome = extras.getString("nome");
        endereco = extras.getString("endereco");
        email = extras.getString("email");
    }
}
