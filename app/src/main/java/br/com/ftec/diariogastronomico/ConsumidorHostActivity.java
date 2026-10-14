package br.com.ftec.diariogastronomico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.ftec.diariogastronomico.ui.fragment.DiarioFragment;
import br.com.ftec.diariogastronomico.ui.fragment.ExplorarFragment;
import br.com.ftec.diariogastronomico.ui.fragment.PerfilFragment;

public class ConsumidorHostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_host_consumidor);

        BottomNavigationView nav = findViewById(R.id.bottomNav);
        nav.setOnItemSelectedListener(item -> {
            trocarFragment(item.getItemId());
            return true;
        });
        if (savedInstanceState == null) {
            nav.setSelectedItemId(R.id.nav_explorar);
        }
    }

    private void trocarFragment(int id) {
        Fragment fragment;
        if (id == R.id.nav_diario) {
            fragment = new DiarioFragment();
        } else if (id == R.id.nav_perfil) {
            fragment = new PerfilFragment();
        } else {
            fragment = new ExplorarFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
