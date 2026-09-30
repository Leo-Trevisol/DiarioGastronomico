package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class AvaliarActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_avaliar);
        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnPublicar, () -> {
            toast("Avaliação publicada!");
            finish();
        });
    }
}
