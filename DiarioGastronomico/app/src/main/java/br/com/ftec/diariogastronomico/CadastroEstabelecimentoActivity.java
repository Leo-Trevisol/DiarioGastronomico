package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class CadastroEstabelecimentoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_cadastro_estabelecimento);
        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnDesativar, () -> toast("Estabelecimento desativado"));
        onClick(R.id.btnSalvar, () -> {
            toast("Alterações salvas!");
            finish();
        });
    }
}
