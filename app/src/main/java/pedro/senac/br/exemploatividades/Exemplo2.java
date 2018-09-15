package pedro.senac.br.exemploatividades;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Exemplo2 extends AppCompatActivity {


    private EditText textNome;
    private RadioButton radioMasc;
    private RadioButton radioFem;
    private Button btnmensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo2);

        textNome = (EditText) findViewById(R.id.txtNome);
        radioMasc = (RadioButton) findViewById(R.id.radioMasc);
        radioFem = (RadioButton) findViewById(R.id.radioFem);
        btnmensagem = (Button) findViewById(R.id.btnMensagem);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = textNome.getText() .toString();
                if(radioMasc.isChecked()){
                    alert("Bem-vindo", "Olá Sr: " + nome );
                }
                else if(radioFem.isChecked()){
                    alert("Bem-vindo", "Olá Sra: " + nome );
                }
                else {
                    alert("Selecione um sexo!!!!!", "Erro");
                }
            }
        };

        btnmensagem.setOnClickListener(listener);
    }

    private void alert(String message, String title) {
        //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exemplo2.this);
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
