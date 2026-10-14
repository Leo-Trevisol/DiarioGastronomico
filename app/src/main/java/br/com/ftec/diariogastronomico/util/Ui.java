package br.com.ftec.diariogastronomico.util;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import br.com.ftec.diariogastronomico.R;

public final class Ui {

    private Ui() {}

    public static void renderStars(LinearLayout container, int nota, int sizeDp) {
        container.removeAllViews();
        Context c = container.getContext();
        int size = Math.round(sizeDp * c.getResources().getDisplayMetrics().density);
        int gold = ContextCompat.getColor(c, R.color.star_gold);
        for (int i = 1; i <= 5; i++) {
            ImageView star = new ImageView(c);
            star.setLayoutParams(new LinearLayout.LayoutParams(size, size));
            star.setImageResource(i <= nota ? R.drawable.ic_star : R.drawable.ic_star_border);
            star.setColorFilter(gold);
            container.addView(star);
        }
    }
}
