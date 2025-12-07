package com.example.mapping;

import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        answer = (TextView) findViewById(R.id.answer);


    }

    public boolean chek(){
        try {
            Double.parseDouble(num1.getText().toString());
            Double.parseDouble(num2.getText().toString());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s = item.getTitle().toString();
        double x = Double.parseDouble(num1.getText().toString());
        double y = Double.parseDouble(num2.getText().toString());

        if (s.equals("clear")){
            answer.setText("");
            num1.setText("");
            num2.setText("");
        }

        if (chek()) {

            if (s.equals("add")) {
                answer.setText(String.format("%.3f", x+y));
            } else if (s.equals("mul")) {
                answer.setText(String.format("%.3f", x*y));
            } else if (s.equals("division")) {
                answer.setText(String.format("%.3f", x/y));
            } else {
                answer.setText(String.format("%.3f", x-y));
            }
        }
        return true;
    }


}