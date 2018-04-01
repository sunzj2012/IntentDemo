package com.example.john.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mybut1;
    private Button mybut2;
    private Button mybut3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybut1=(Button) findViewById(R.id.button1);
        mybut2=(Button) findViewById(R.id.button2);
        mybut3=(Button) findViewById(R.id.button3);

        mybut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,FirstActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString ("data","青岛职业技术学院");
                intent1.putExtras(bundle);
                //startActivity(intent1);
                startActivityForResult(intent1,1);

            }
        });
        mybut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/contacts"));
                startActivity(intent4);
            }
        });
        mybut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent4=new Intent(Intent.ACTION_VIEW, Uri.parse("content://com.android.contacts/contacts"));
                startActivity(intent4);*/
                Intent intent2=new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("intentdemo://cn.edu.qtc"));
                startActivity(intent2);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Bundle random=data.getExtras();
                Toast.makeText(MainActivity.this,random.getInt("random")+"",Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
