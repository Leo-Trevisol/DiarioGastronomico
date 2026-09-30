package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_main);
        onClick(R.id.btnEntrar, () -> go(LoginActivity.class));
        onClick(R.id.btnCriarConta, () -> go(CadastroActivity.class));
    }
}
