    package com.example.noaguantomas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void login(View v){
        EditText campo1= this.findViewById(R.id.rut);
        String rut = campo1.getText().toString();

        EditText campo2 = this.findViewById(R.id.pass);
        String password = campo2.getText().toString();

        if (rut.equals("123")&&password.equals("123")){
            Intent i=new Intent(this,Home.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "RUT o contrasena incorrectos", Toast.LENGTH_SHORT).show();
        }


    }


    }