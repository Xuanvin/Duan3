package com.example.apduantotnghiep.Fragment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apduantotnghiep.R;

public class MaQR extends AppCompatActivity {
    String inten;
    Button coppy;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_qr);
       textView=findViewById(R.id.qr);
       coppy=findViewById(R.id.copy);
      Bundle bundle=getIntent().getExtras();
      coppy.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
              ClipData clip = ClipData.newPlainText("Đã sao chép", textView.getText().toString());
              Toast.makeText(MaQR.this, "Đã sao chép", Toast.LENGTH_SHORT).show();
              clipboard.setPrimaryClip(clip);
          }
      });
        textView.setText(bundle.getString("name"));

    }
}
