package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class PerfilActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_perfil);
        bindConsumerNav(R.id.nav_perfil);
        onClick(R.id.btnEditarPerfil, () -> toast("Editar perfil"));
    }

    @Override
    protected boolean applyTopInset() {
        return false;
    }
}
