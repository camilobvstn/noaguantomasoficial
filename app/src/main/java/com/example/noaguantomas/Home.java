package com.example.noaguantomas;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent intent = getIntent();
        String showFragment = intent.getStringExtra("showFragment");


        if (showFragment != null && showFragment.equals("mensajes")) {
            mensajes m = new mensajes();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, m).commit();
        } else {

            inicio i = new inicio();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, i).commit();
        }


        TabLayout tl = findViewById(R.id.tabmain);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        inicio i = new inicio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, i).commit();
                        break;
                    case 1:
                        mensajes m = new mensajes();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, m).commit();
                        break;
                    case 2:
                        perfil p = new perfil();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, p).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Implementar si es necesario
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Implementar si es necesario
            }
        });
    }
}

