package com.example.textviewautorunningtext;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvFeedback1, tvFeedback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvFeedback1 = findViewById(R.id.tvFeedback1);
        tvFeedback2 = findViewById(R.id.tvFeedback2);

        tvFeedback2.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = tvFeedback2.getLineCount();

                Log.d("TAG", "Line Count : " + String.valueOf(lineCount));

                if (lineCount>1){
                    Log.d("TAG", "Start Running Text");
                    tvFeedback2.setSingleLine(true);
                    tvFeedback2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    tvFeedback2.setSelected(true);
                }
            }
        });
    }
}