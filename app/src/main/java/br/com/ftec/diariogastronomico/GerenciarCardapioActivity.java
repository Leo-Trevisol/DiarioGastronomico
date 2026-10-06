package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class GerenciarCardapioActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_gerenciar_cardapio);
        bindRestaurantNav(R.id.nav_cardapio);
        onClick(R.id.fabAddPrato, () -> go(CadastroPratoActivity.class));
    }
}
