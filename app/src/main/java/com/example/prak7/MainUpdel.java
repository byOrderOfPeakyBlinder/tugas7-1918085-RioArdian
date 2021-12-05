package com.example.prak7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sjenis, Spengertian;
    private EditText Ejenis, Epengertian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjenis = i.getStringExtra("Ijenis");
        Spengertian = i.getStringExtra("Ipengertian");
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Epengertian = (EditText) findViewById(R.id.updel_pengertian);
        Ejenis.setText(Sjenis);
        Epengertian.setText(Spengertian);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjenis = String.valueOf(Ejenis.getText());
                Spengertian = String.valueOf(Epengertian.getText());
                if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Jenis",
                            Toast.LENGTH_SHORT).show();
                } else if (Spengertian.equals("")){
                    Epengertian.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Pengertian",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateParfum (new Parfum ( Sid, Sjenis,
                            Spengertian));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteParfum (new Parfum (Sid, Sjenis,
                        Spengertian));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}