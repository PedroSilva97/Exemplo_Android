package pedro.senac.br.exemploatividades.atividades;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pedro.senac.br.exemploatividades.R;

public class Exemplo1 extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobre;
    Button btnmensagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo1);

        txtNome = findViewById(R.id.txtNome);
        txtSobre = findViewById(R.id.txtSobre);


        btnmensagem = findViewById(R.id.btnMensagem);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText() .toString();
                String Snome = txtSobre.getText() .toString();

                if (nome.trim() .equals("")){
                    alert("Preecha o campo nome", "Erro");
                }else if (Snome.trim() .equals("")){
                    alert("Preecha o campo Sobrenome", "Erro");
                }else {
                    alert("Bem-vindo a Westeros  ", "Olá  " + txtNome.getText() + " " + txtSobre.getText());
                }
            }
        };
        btnmensagem.setOnClickListener(listener);
    }

    private void alert(String message, String title){
            //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exemplo1.this);
            //Configura o corpo da mensagem
        builder.setMessage(message);
            //Configura o título da mensagem
        builder.setTitle(title);
            //Impede que o botão seja cancelável (possa clicar
            //em voltar ou fora para fechar)
        builder.setCancelable(false);
            //Configura um botão de OK para fechamento (um
            //outro listener pode ser configurado no lugar do "null")
        builder.setPositiveButton("OK", null);
            //Cria efetivamente o diálogo
        AlertDialog dialog = builder.create();
            //Faz com que o diálogo apareça na tela
        dialog.show();

    }
}
