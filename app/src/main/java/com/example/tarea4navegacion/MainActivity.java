package com.example.tarea4navegacion;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

        //getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.contenedorFragmento, FragmentoNav.class, null).commit();
        //getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.contenedorFragmento, FragmentoNav1.class, null).commit();
        //getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.contenedorFragmento, FragmentoNav2.class, null).commit();

        FragmentoNav fragmento = new FragmentoNav();
        FragmentoNav1 fragmento1 = new FragmentoNav1();
        FragmentoNav2 fragmento2 = new FragmentoNav2();

        BottomNavigationView bnv = findViewById(R.id.vistaNavegacion);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.opc1){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.contenedorFragmento, FragmentoNav.class, null)
                            .commit();
                    return true;
                }else if(item.getItemId()==R.id.opc2){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.contenedorFragmento, FragmentoNav1.class, null)
                            .commit();
                    return true;
                }else if (item.getItemId()==R.id.opc3){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.contenedorFragmento, FragmentoNav2.class, null)
                            .commit();
                    return true;
                }else {
                    return false;
                }
            }
        });


    }
}