package com.example.ukasz.cwiczenia4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public final static String RETURN_ACTIVITY ="returnValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        try {
            Intent intent = getIntent();
            String value = intent.getStringExtra(MainActivity.NEW_ACTIVITY_EXTRA_1);
            Toast.makeText(getBaseContext(),value,Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(getBaseContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }

        final EditText editTextValueMain2 = findViewById(R.id.editTextMain2);
        Button buttonMain2 = findViewById(R.id.labelButtonReturn);

        buttonMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(editTextValueMain2!=null){
                        String editTextValueMain2String = editTextValueMain2.getText().toString();
                        if(editTextValueMain2String != null && !editTextValueMain2String.isEmpty()){
                            Intent intentMain2 = getIntent();
                            intentMain2.putExtra(RETURN_ACTIVITY, editTextValueMain2String);
                            setResult(MainActivity.NEW_ACTIVITY_RESULT_1,intentMain2);
                            finish();
                        }
                    }

                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
