package com.example.prak7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Parfum> ListParfum = new
            ArrayList<Parfum>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListParfum
        );
        mListView = (ListView) findViewById(R.id.list_parfum);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListParfum.clear();
        List<Parfum> Parfum = db.ReadParfum();
        for (Parfum pr : Parfum) {
            Parfum daftar = new Parfum();
            daftar.set_id(pr.get_id());
            daftar.set_jenis(pr.get_jenis());
            daftar.set_pengertian(pr.get_pengertian());
            ListParfum.add(daftar);
            if ((ListParfum.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
            Parfum   detailPr = (Parfum)o;
        String Sid = detailPr.get_id();
        String Sjenis = detailPr.get_jenis();
        String Spengertian = detailPr.get_pengertian();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Ipengertian", Spengertian);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListParfum.clear();
        mListView.setAdapter(adapter_off);
        List<Parfum> parfum = db.ReadParfum();
        for (Parfum pr : parfum) {
            Parfum daftar = new Parfum();
            daftar.set_id(pr.get_id());
            daftar.set_jenis(pr.get_jenis());
            daftar.set_pengertian(pr.get_pengertian());
            ListParfum.add(daftar);
            if ((ListParfum.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}