package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class ExplorarActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_explorar);
        bindConsumerNav(R.id.nav_explorar);
        onClick(R.id.card_ph_cover_1, () -> go(RestauranteDetalheActivity.class));
        onClick(R.id.card_ph_cover_3, () -> go(RestauranteDetalheActivity.class));
        onClick(R.id.card_ph_cover_2, () -> go(RestauranteDetalheActivity.class));
    }
}
