package com.example.ukasz.cwiczenia4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public final static String NEW_ACTIVITY_EXTRA_1 = "extraValue1";
    public final static int NEW_ACTIVITY_RESULT_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextValue=findViewById(R.id.editTextMain);
        Button buttonMain = findViewById(R.id.labelButton);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(editTextValue!=null){
                        String editTextValueString = editTextValue.getText().toString();
                        if (editTextValueString != null && !editTextValueString.isEmpty()){
                            Intent intentToMain2 = new Intent(getBaseContext(),Main2Activity.class);
                            intentToMain2.putExtra(NEW_ACTIVITY_EXTRA_1, editTextValueString);
                            startActivityForResult(intentToMain2, NEW_ACTIVITY_RESULT_1);
                        }
                    }
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }





            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(NEW_ACTIVITY_RESULT_1 == requestCode){
                if(requestCode== Activity.RESULT_FIRST_USER){
                    if(data != null){
                        String value = data.getStringExtra(Main2Activity.RETURN_ACTIVITY);
                        Toast.makeText(getBaseContext(),value,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        catch (Exception e){
            Toast.makeText(getBaseContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
