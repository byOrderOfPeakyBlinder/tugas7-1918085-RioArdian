package com.example.prak7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ejenis, Epengertian;
    private String Sjenis, Spengertian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Epengertian = (EditText) findViewById(R.id.create_pengertian);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Spengertian = String.valueOf(Epengertian.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Spengertian.equals("")) {
                    Epengertian.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi pengertian",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Ejenis.setText("");
                    Epengertian.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateParfum (new Parfum (null, Sjenis   , Spengertian));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}