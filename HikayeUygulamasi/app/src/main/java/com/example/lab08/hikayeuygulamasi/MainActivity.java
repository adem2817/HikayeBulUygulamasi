package com.example.lab08.hikayeuygulamasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public EditText ara;
    public RadioGroup tur;
    public RadioButton rb;
    public TextView hikaye;
    public String icerik;
    public String icerik2;
    public String hikaye1;
    public String hikaye2;
    public Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Map<String,String> hikayeler = new HashMap<String, String>();

        hikayeler.put("yetişkin",getResources().getString(R.string.bir_kardelen_masali));
        hikayeler.put("çocuk",getResources().getString(R.string.kirmizi_araba));

        init();

        tur.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = findViewById(checkedId);
                icerik = rb.getText().toString();
            }
        });

        ara.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){

                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HikayedeAra = hikayeler.get(icerik);
                if(HikayedeAra.contains(((EditText) findViewById(R.id.ara)).getText().toString())){
                    hikaye.setText(hikayeler.get(icerik));
                }else{
                    hikaye.setText("Aradağınız hikayeye şuanda ulaşılmıyor lütfen daha sonra tekrar deneyizniz ! :)");
                }
            }
        });
    }
    public void init(){
        ara = findViewById(R.id.ara);
        tur = findViewById(R.id.tur);
        hikaye = findViewById(R.id.hikaye);
        btn1 = findViewById(R.id.button);

    }


}

