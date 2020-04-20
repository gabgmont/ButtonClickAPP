package com.example.buttonclickapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //criação de variáveis
    private EditText editText;
    private TextView textView;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: started");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linkando com os elementos do layout
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        textView.setText("");
        editText.setText("");

        //método para rolar a página quando o espaço na tela acabar
        textView.setMovementMethod(new ScrollingMovementMethod());

        //método para verificar o clique do botão
        View.OnClickListener buttonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // definir ação de clique
                String result = editText.getText().toString();
                result += "\n";
                textView.append(result);
                editText.setText("");
            }
        };
        //chamada do método de clique do botão
        button.setOnClickListener(buttonClick);
        Log.d(TAG, "onCreate: finished");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //Salva os dados antes de pausar a aplicação (trocar orientação da tela)
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        //Recupera os dados salvos depois de criar a atividade novamente
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
    }
}