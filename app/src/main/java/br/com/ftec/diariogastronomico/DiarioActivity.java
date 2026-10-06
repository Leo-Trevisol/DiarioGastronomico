package br.com.ftec.diariogastronomico;

import android.os.Bundle;

public class DiarioActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(R.layout.activity_diario);
        bindConsumerNav(R.id.nav_diario);
    }
}
