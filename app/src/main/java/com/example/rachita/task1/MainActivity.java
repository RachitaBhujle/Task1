package com.example.rachita.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.rachita.task1.SecondActivity.REQ_CD1;

public class MainActivity extends AppCompatActivity {
EditText et1;
    TextView tv1,tv2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,SecondActivity.class);
                in.putExtra("number",et1.getText().toString());
                startActivityForResult(in,REQ_CD1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CD1){
            if(resultCode == RESULT_OK){
                Bundle b = data.getExtras();
                int num = b.getInt("val");
                tv1.setText("success");
                tv2.setText(""+num);

            }
            else{

                Bundle b = data.getExtras();
                int num = b.getInt("val");
                tv1.setText("failure");
                tv2.setText(""+num);
            }
        }
    }
}
