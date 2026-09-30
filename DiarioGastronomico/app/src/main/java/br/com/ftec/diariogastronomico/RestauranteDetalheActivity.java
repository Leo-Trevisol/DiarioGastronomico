package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class RestauranteDetalheActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_restaurante_detalhe);
        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnAvaliar, () -> go(AvaliarActivity.class));
        onClick(R.id.prato_ph_food_1, () -> go(PratoDetalheActivity.class));
        onClick(R.id.prato_ph_food_4, () -> go(PratoDetalheActivity.class));
        onClick(R.id.prato_ph_food_5, () -> go(PratoDetalheActivity.class));
    }

    @Override
    protected boolean applyTopInset() {
        return false;
    }
}
