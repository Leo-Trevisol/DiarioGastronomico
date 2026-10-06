package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class RestaurantePainelActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_restaurante_painel);
        bindRestaurantNav(R.id.nav_painel);
        onClick(R.id.actNovoPrato, () -> go(CadastroPratoActivity.class));
        onClick(R.id.actEditarEstab, () -> go(CadastroEstabelecimentoActivity.class));
    }
}
