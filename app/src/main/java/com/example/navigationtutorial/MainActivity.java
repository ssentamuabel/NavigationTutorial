package com.example.navigationtutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



import android.os.Bundle;
import android.view.MenuItem;

import com.example.navigationtutorial.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


       binding.bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch(item.getItemId()){
                   case R.id.profile:
                       replaceFragment(new ProfileFragment());
                       item.setChecked(true);
                   break;
                   case R.id.home:
                       replaceFragment(new HomeFragment());
                       item.setChecked(true);
                       break;
                   case R.id.settings:
                       replaceFragment(new SettingFragment());
                       item.setChecked(true);
                       break;
               }
               return false;
           }
       });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commit();

    }
}