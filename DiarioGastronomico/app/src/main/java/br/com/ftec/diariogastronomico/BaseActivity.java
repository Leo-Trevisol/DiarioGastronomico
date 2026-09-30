package br.com.ftec.diariogastronomico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Activity base: edge-to-edge, tratamento de insets e helpers de navegação.
 * As telas são mockadas — a lógica aqui apenas navega entre as activities.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected void init(int layoutRes) {
        EdgeToEdge.enable(this);
        setContentView(layoutRes);
        View root = findViewById(R.id.main);
        if (root != null) {
            ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
                Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                int top = applyTopInset() ? bars.top : 0;
                v.setPadding(bars.left, top, bars.right, bars.bottom);
                return insets;
            });
        }
    }

    /** Telas com foto de capa em tela cheia sobrescrevem para false. */
    protected boolean applyTopInset() {
        return true;
    }

    protected void go(Class<?> target) {
        startActivity(new Intent(this, target));
    }

    protected void onClick(int id, Runnable action) {
        View v = findViewById(id);
        if (v != null) v.setOnClickListener(x -> action.run());
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void bindConsumerNav(int selfId) {
        BottomNavigationView nav = findViewById(R.id.bottomNav);
        if (nav == null) return;
        nav.setSelectedItemId(selfId);
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == selfId) return true;
            if (id == R.id.nav_explorar) go(ExplorarActivity.class);
            else if (id == R.id.nav_diario) go(DiarioActivity.class);
            else if (id == R.id.nav_perfil) go(PerfilActivity.class);
            overridePendingTransition(0, 0);
            finish();
            return true;
        });
    }

    protected void bindRestaurantNav(int selfId) {
        BottomNavigationView nav = findViewById(R.id.bottomNav);
        if (nav == null) return;
        nav.setSelectedItemId(selfId);
        nav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == selfId) return true;
            if (id == R.id.nav_painel) go(RestaurantePainelActivity.class);
            else if (id == R.id.nav_cardapio) go(GerenciarCardapioActivity.class);
            else if (id == R.id.nav_avaliacoes) go(AvaliacoesRecebidasActivity.class);
            overridePendingTransition(0, 0);
            finish();
            return true;
        });
    }
}
