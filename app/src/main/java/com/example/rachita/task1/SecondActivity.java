package com.example.rachita.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
Button success,failure;
    static final int REQ_CD1=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        final int val = Integer.parseInt (b.getString("number"));

        success = (Button) findViewById(R.id.buttonSA1);
        failure = (Button) findViewById(R.id.buttonSA2);
        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent();
                in.putExtra("val",val*2);
                setResult(RESULT_OK,in);
                finish();
            }

        });
        failure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent();
                in.putExtra("val",val/2);
                setResult(RESULT_CANCELED,in);
                finish();
            }
        });
    }
}
