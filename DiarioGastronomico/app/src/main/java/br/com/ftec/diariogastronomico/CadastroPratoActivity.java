package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class CadastroPratoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_cadastro_prato);
        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnSalvarPrato, () -> {
            toast("Prato salvo!");
            finish();
        });
    }
}
