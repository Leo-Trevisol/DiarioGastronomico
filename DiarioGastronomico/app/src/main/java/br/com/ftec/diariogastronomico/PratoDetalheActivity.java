package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class PratoDetalheActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_prato_detalhe);
        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnAvaliarPrato, () -> go(AvaliarActivity.class));
    }

    @Override
    protected boolean applyTopInset() {
        return false;
    }
}
