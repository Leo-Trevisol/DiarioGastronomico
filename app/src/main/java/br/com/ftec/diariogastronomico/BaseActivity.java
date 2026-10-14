package br.com.ftec.diariogastronomico;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public abstract class BaseActivity extends AppCompatActivity {

    protected void init(int layoutRes) {
        EdgeToEdge.enable(this);
        setContentView(layoutRes);
        View root = findViewById(R.id.main);
        if (root != null) {
            ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
                Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                int top = applyTopInset() ? bars.top : 0;
                v.setPadding(bars.left, top, bars.right, bars.bottom);
                return insets;
            });
        }
    }

    protected boolean applyTopInset() {
        return true;
    }

    protected void go(Class<?> target) {
        startActivity(new Intent(this, target));
    }

    protected void onClick(int id, Runnable action) {
        View v = findViewById(id);
        if (v != null) v.setOnClickListener(x -> action.run());
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
