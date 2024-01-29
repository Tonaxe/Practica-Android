package com.example.unavezportodas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.unavezportodas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Agregar el listener para el NavigationView
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Manejar la selección de Home
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.nav_home);
                } else if (id == R.id.nav_gallery) {
                    // Manejar la selección de Gallery
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.nav_gallery);
                } else if (id == R.id.nav_slideshow) {
                    // Manejar la selección de Slideshow
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.nav_slideshow);
                } else if (id == R.id.nav_recyclerview) {
                    // Manejar la selección de RecyclerView
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.recyclerElementosFragment);
                }
                else if (id == R.id.nav_entrenador) {
                    // Manejar la selección de LiveData (EntrenadorFragment)
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.entrenadorFragment);
                }
                else if (id == R.id.nav_retrofit) {
                        // Manejar la selección de LiveData (EntrenadorFragment)
                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                        navController.navigate(R.id.itunesFragment);
                }
                else if (id == R.id.nav_share) {
                    // Manejar la selección de LiveData (EntrenadorFragment)
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.shareFragment);
                }
                else if (id == R.id.nav_juego) {
                    // Manejar la selección de LiveData (EntrenadorFragment)
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.juegoFragment);
                }
                else if (id == R.id.nav_juego2) {
                    // Manejar la selección de LiveData (EntrenadorFragment)
                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.guessNumberFragment);

            }



                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}