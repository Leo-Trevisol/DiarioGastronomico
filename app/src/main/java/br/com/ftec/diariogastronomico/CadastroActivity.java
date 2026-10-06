package br.com.ftec.diariogastronomico;

import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;

public class CadastroActivity extends BaseActivity {

    private boolean tipoRestaurante = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_cadastro);

        MaterialCardView cardConsumidor = findViewById(R.id.cardConsumidor);
        MaterialCardView cardRestaurante = findViewById(R.id.cardRestaurante);

        cardConsumidor.setOnClickListener(v -> {
            tipoRestaurante = false;
            selecionar(cardConsumidor, cardRestaurante);
        });
        cardRestaurante.setOnClickListener(v -> {
            tipoRestaurante = true;
            selecionar(cardRestaurante, cardConsumidor);
        });

        onClick(R.id.btnVoltar, this::finish);
        onClick(R.id.txtEntrar, this::finish);
        onClick(R.id.btnCadastrar, () ->
                go(tipoRestaurante ? RestaurantePainelActivity.class : ExplorarActivity.class));
    }

    private void selecionar(MaterialCardView ativo, MaterialCardView inativo) {
        int brand = getColor(R.color.brand_primary);
        int outline = getColor(R.color.outline);
        ativo.setStrokeColor(brand);
        ativo.setStrokeWidth(dp(2));
        ativo.setCardBackgroundColor(0x14E86A1C);
        inativo.setStrokeColor(outline);
        inativo.setStrokeWidth(dp(1));
        inativo.setCardBackgroundColor(getColor(R.color.surface));
    }

    private int dp(int v) {
        return Math.round(v * getResources().getDisplayMetrics().density);
    }
}
