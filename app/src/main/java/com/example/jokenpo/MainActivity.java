package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TextView;
import java.lang.String;
import android.widget.ImageView;




import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String vcEscolheu, cpuEscolheu;
    public TextView resul, lblVc, lblCpu, vitoriasVc, vitoriasCpu;
    public String jogoCpu[] = {"Tesoura", "Pedra", "Papel"};//Essas são as três opções da CPU
    public Button btnPedra, btnPapel, btnTeso, btnJogar, btnClose;
    public ImageView seuJoken, cpuJoken;
    public int contVc = 0;
    public int contCpu = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Suas Escolhas em Label
        lblCpu = findViewById(R.id.lblCpu);
        lblVc = findViewById(R.id.lblSeu);
        vitoriasCpu = findViewById(R.id.vitoriasCpu);
        vitoriasVc = findViewById(R.id.vitoriasVc);

        //Botoes
        btnPedra = findViewById(R.id.btnPedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTeso = findViewById(R.id.btnTesou);
        btnJogar = findViewById(R.id.btnJogar);
        btnClose = findViewById(R.id.close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Resultado
        resul = findViewById(R.id.resultado);

        //Imagens das escolhas
        seuJoken = findViewById(R.id.imgVc);
        cpuJoken = findViewById(R.id.imgCpu);


        //Botao Pedra
        btnPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seuJoken.setImageResource(R.drawable.pedra);
                btnJogar.setEnabled(true);
                vcEscolheu = "Pedra";
                lblEscolhidas();
            }
        });


        //Botao Papel
        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seuJoken.setImageResource(R.drawable.papel);
                btnJogar.setEnabled(true);
                vcEscolheu = "Papel";
                lblEscolhidas();
            }
        });

        //Botao Tesoura
        btnTeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seuJoken.setImageResource(R.drawable.tesoura);
                btnJogar.setEnabled(true);
                vcEscolheu = "Tesoura";
                lblEscolhidas();
            }
        });


        //Botao Jogar
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quemVenceuPorVez();
                btnJogar.setEnabled(false);
            }
        });
    }


    public void lblEscolhidas() {
        cpuJoken.setImageResource(R.drawable.cpu);
        lblVc.setText(vcEscolheu);
        resul.setVisibility(View.INVISIBLE);
        lblCpu.setVisibility(View.INVISIBLE);
    }

    public void cpuEscolheu() {//A jogada da CPU
        Random rndCpu = new Random();//Variavel randomica
        int cpu;//Receber um numero

        cpu = rndCpu.nextInt(3);//Aqui terá um numero de 0 a 2, totalizando 3 posições

        cpuEscolheu = String.valueOf(jogoCpu[cpu]);//Aqui é a escolha da CPU

        lblCpu.setText(jogoCpu[cpu]);
        lblCpu.setVisibility(View.VISIBLE);


        if (jogoCpu[cpu] == "Pedra") {
            cpuJoken.setImageResource(R.drawable.pedra);
            cpuEscolheu = jogoCpu[cpu];
        } else if (jogoCpu[cpu] == "Tesoura") {
            cpuJoken.setImageResource(R.drawable.tesoura);
            cpuEscolheu = jogoCpu[cpu];
        } else {//Papel
            cpuJoken.setImageResource(R.drawable.papel);
            cpuEscolheu = jogoCpu[cpu];
        }

    }

    public void quemVenceuPorVez() {
        cpuEscolheu();


        if ((vcEscolheu == "Tesoura") && (cpuEscolheu == "Papel")) {
            resul.setVisibility(View.VISIBLE);
            resul.setTextColor(Color.GREEN);
            resul.setText("Vc venceu");
            contVc++;
            vitoriasVc.setText("Vitórias: " + contVc);

        } else if ((vcEscolheu == "Papel") && (cpuEscolheu == "Pedra")) {
            resul.setVisibility(View.VISIBLE);
            resul.setTextColor(Color.GREEN);
            resul.setText("Vc venceu");
            contVc++;
            vitoriasVc.setText("Vitórias: " + contVc);

        } else if ((vcEscolheu == "Pedra") && (cpuEscolheu == "Tesoura")) {
            resul.setVisibility(View.VISIBLE);
            resul.setTextColor(Color.GREEN);
            resul.setText("Vc venceu");
            contVc++;
            vitoriasVc.setText("Vitórias: " + contVc);

        } else if (vcEscolheu == cpuEscolheu) {
            resul.setVisibility(View.VISIBLE);
            resul.setText("Empatou");
            resul.setTextColor(Color.BLUE);

        } else {
            resul.setVisibility(View.VISIBLE);
            resul.setText("Vc perdeu");
            resul.setTextColor(Color.RED);
            contCpu++;
            vitoriasCpu.setText(contCpu+" :Vitórias");

        }
    }


    public void contadores() {
        for (int i = 0; i > jogoCpu.length; i++) {
            quemVenceuPorVez();
        }

    }
}






