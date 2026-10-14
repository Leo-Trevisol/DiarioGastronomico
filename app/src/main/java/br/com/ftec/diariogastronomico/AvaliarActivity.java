package br.com.ftec.diariogastronomico;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AvaliarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_avaliar);

        String alvoNome = getIntent().getStringExtra("alvoNome");
        String alvoDesc = getIntent().getStringExtra("alvoDesc");
        int alvoImagem = getIntent().getIntExtra("alvoImagem", R.drawable.ph_cover_1);

        if (alvoNome != null) ((TextView) findViewById(R.id.txtAlvoNome)).setText(alvoNome);
        if (alvoDesc != null) ((TextView) findViewById(R.id.txtAlvoDesc)).setText(alvoDesc);
        ((ImageView) findViewById(R.id.imgAlvo)).setImageResource(alvoImagem);

        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.btnPublicar, () -> {
            toast("Avaliação publicada!");
            finish();
        });
    }
}
