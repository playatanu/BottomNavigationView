package com.playatanu.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.nav);

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.chat:
                        fragmentTransaction.replace(R.id.fragment,new ChatFragment());

                        break;

                    case R.id.call:
                        fragmentTransaction.replace(R.id.fragment,new CallFragment());

                        break;
                    case R.id.about:
                        fragmentTransaction.replace(R.id.fragment,new AboutFragment());

                        break;

                }
                fragmentTransaction.commit();
                return true;
            }
        });





    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.call:
                Toast.makeText(this,"Call",Toast.LENGTH_LONG).show();
                break;
            case R.id.chat:
                Toast.makeText(this,"Chat",Toast.LENGTH_LONG).show();
                break;
            case R.id.about:
                Toast.makeText(this,"About",Toast.LENGTH_LONG).show();
                break;



        }

        return super.onOptionsItemSelected(item);

    }


}











