package com.example.john.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class FirstActivity extends AppCompatActivity {
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        back=(Button) findViewById(R.id.back);
        Bundle bundle = this.getIntent().getExtras();
        String result = bundle.getString ("data");
        Toast.makeText(FirstActivity.this,result+"",Toast.LENGTH_LONG).show();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand =new Random();
                int r=rand.nextInt(100);
                Bundle bundle=new Bundle();
                bundle.putInt("random",r);
                Intent intent3=new Intent(FirstActivity.this,MainActivity.class);
                intent3.putExtras(bundle);
                setResult(RESULT_OK, intent3);
                finish();
            }
        });

    }
}
