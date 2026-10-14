package br.com.ftec.diariogastronomico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.ftec.diariogastronomico.ui.fragment.AvaliacoesFragment;
import br.com.ftec.diariogastronomico.ui.fragment.CardapioFragment;
import br.com.ftec.diariogastronomico.ui.fragment.PainelFragment;

public class RestauranteHostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_host_restaurante);

        BottomNavigationView nav = findViewById(R.id.bottomNav);
        nav.setOnItemSelectedListener(item -> {
            trocarFragment(item.getItemId());
            return true;
        });
        if (savedInstanceState == null) {
            nav.setSelectedItemId(R.id.nav_painel);
        }
    }

    private void trocarFragment(int id) {
        Fragment fragment;
        if (id == R.id.nav_cardapio) {
            fragment = new CardapioFragment();
        } else if (id == R.id.nav_avaliacoes) {
            fragment = new AvaliacoesFragment();
        } else {
            fragment = new PainelFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
