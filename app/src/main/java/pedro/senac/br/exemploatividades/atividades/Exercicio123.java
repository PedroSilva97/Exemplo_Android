package pedro.senac.br.exemploatividades.atividades;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import pedro.senac.br.exemploatividades.R;

public class Exercicio123 extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobre;
    Button btnmensagem;
    RadioButton rbdMasc;
    RadioButton rbdFem;
    RadioButton rbdviuvo;
    RadioButton rbdCasado;
    RadioButton rbdSolteiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo1);

        txtNome = findViewById(R.id.txtNome);
        txtSobre = findViewById(R.id.txtSobre);
        rbdMasc = findViewById(R.id.rbdMas);
        rbdFem = findViewById(R.id.rbdFem);
        rbdviuvo = findViewById(R.id.rbdViuvo);
        rbdCasado = findViewById(R.id.rbdCasado);
        rbdSolteiro = findViewById(R.id.rbdSolteiro);


        btnmensagem = findViewById(R.id.btnMensagem);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText() .toString();
                String Snome = txtSobre.getText() .toString();
                String sexo;
                String estado = "";
                String msg = "";

                if(rbdMasc.isChecked()){
                    sexo = "Masculino";
                }else{
                    sexo = "Feminino";
                }

                if(rbdCasado.isChecked()){
                    estado = "Casado";
                }else if(rbdSolteiro.isChecked()){
                    estado = "Solteiro";
                }else {
                    estado = "Viuvo";
                }



                if (nome.trim() .equals("")){
                    alert("Preecha o campo nome", "Erro");
                }else if (Snome.trim() .equals("")){
                    alert("Preecha o campo Sobrenome", "Erro");
                }else if (!rbdMasc.isChecked() && !rbdFem.isChecked()){
                    alert("Escolha o sexo", "Erro");
                }else if((!rbdCasado.isChecked() && !rbdSolteiro.isChecked()) && (!rbdviuvo.isChecked())){
                    alert("Escolha o seu estado civil", "Erro");
                }




                else {
                    msg =  "Bem-Vindo a Westeros"  + "\n Sexo: " + sexo + "\n Estado Civil: " + estado;
                    alert(msg, "Olá: " +txtNome.getText() + " " + txtSobre.getText() );
                }
            }
        };
        btnmensagem.setOnClickListener(listener);
    }

    private void alert(String message, String title){
            //Declara e instancia uma fábrica de construção de diálogos
        AlertDialog.Builder builder = new AlertDialog.Builder(Exercicio123.this);
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
