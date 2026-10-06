package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class AvaliacoesRecebidasActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_avaliacoes_recebidas);
        bindRestaurantNav(R.id.nav_avaliacoes);
    }
}
