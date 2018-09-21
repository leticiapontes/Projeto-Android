package br.com.makinfunapps.alunoslista;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
        implements AdapterView.OnItemClickListener, View.OnClickListener{

    EditText nomeEditText;
    EditText sobrenomeEditText ;
    EditText emailEditText;
    EditText senhaEditText;
    EditText resenhaEditText;
    Button botao ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associar os componentes do Layout com a Activity.
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        sobrenomeEditText = (EditText) findViewById(R.id.sobrenomeEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        resenhaEditText = (EditText) findViewById(R.id.resenhaEditText);

        botao = (Button) findViewById(R.id.enviarButton);
        botao.setOnClickListener(this);


        // Adicionando o TextWatcher como Listener do EditText.
        senhaEditText.addTextChangedListener(watch_senha);
        resenhaEditText.addTextChangedListener(watch_resenha);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),
                "Nome: "+ nomeEditText + " " + sobrenomeEditText + " Senha: " + senhaEditText,
                Toast.LENGTH_SHORT).show();

    }

    // Listener do EditText.
    TextWatcher watch_senha = new TextWatcher(){

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        /**
         * Acompanha os valores digitados no campo de edição de texto (EditText).
         *
         */
        @Override
        public void onTextChanged(CharSequence text,
                                  int start,
                                  int before,
                                  int count) {
            // Inserir texto digitado no EditText no TextView.
            //hintTextView.setText(text);

            // Exibir a mensagem caso o texto digitado tenha menos de 6 caracteres.
            if(text.length() <= 5){
                Toast.makeText(getApplicationContext(),
                        "Tamanho mínimo de 6 caracteres.",
                        Toast.LENGTH_SHORT).show();
            }


            //Exibir msg se tiver mais ou menos do que dois caracteres numericos.
            int soma = 0;
            for(int i=0;i<text.length();i++){
                if(Character.isDigit(text.charAt(i)) == true){
                    soma+=1;
                }
            }
            if(soma<2 || soma>2){
                Toast.makeText(getApplicationContext(),
                        "Quantidade de caracteres numericos deve ser 2",
                        Toast.LENGTH_SHORT).show();
            }


            //Exibir msg se o nome do usuario estiver igual a senha.
            if(text.equals(nomeEditText.getText().toString())){
                Toast.makeText(getApplicationContext(),
                        "Senha não pode ser igual o nome do usuário",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };


    TextWatcher watch_resenha = new TextWatcher(){

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        /**
         * Acompanha os valores digitados no campo de edição de texto (EditText).
         *
         */
        @Override
        public void onTextChanged(CharSequence text,
                                  int start,
                                  int before,
                                  int count) {
            // Inserir texto digitado no EditText no TextView.
            //hintTextView.setText(text);

            // Exibir a mensagem caso o texto digitado na re-senha seja diferente da senha.
            if(!text.equals(senhaEditText.getText().toString())){
                Toast.makeText(getApplicationContext(),
                        "Sua senha esta incorreta.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

}
