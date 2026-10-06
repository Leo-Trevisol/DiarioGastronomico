package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_login);
        onClick(R.id.btnEntrar, () -> go(ExplorarActivity.class));
        onClick(R.id.txtCriarConta, () -> go(CadastroActivity.class));
    }
}
