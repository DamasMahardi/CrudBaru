package com.example.crudbaru.controller.read;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudbaru.R;
import com.example.crudbaru.database.DataHelper;
import com.example.crudbaru.model.Karyawan;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DataHelper dbHelper;
    private List<Karyawan> karyawanList = new ArrayList<>();
    private TextView tvId;
    KaryawanAdapter karyawanAdapter;
    ImageView imBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        mRecyclerView = findViewById(R.id.list_Data);
        tvId = findViewById(R.id.tv_id);
        imBack = findViewById(R.id.iv_ToolbarBack);
        dbHelper = new DataHelper(this);

        karyawanAdapter = new KaryawanAdapter(this, karyawanList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(karyawanAdapter);
        karyawanList.clear();

        List<Karyawan> list = dbHelper.readDataKaryawan();
        for (Karyawan contact:list){
            Karyawan model = new Karyawan();
            model.setId(contact.getId());
            model.setName(contact.getName());
            model.setJabatan(contact.getJabatan());
            model.setAlamat(contact.getAlamat());
            model.setEmail(contact.getEmail());
            model.setTelephone(contact.getTelephone());
            karyawanList.add(model);

            if (karyawanList.isEmpty()){
                Toast.makeText(this, "Tidak Ada Data !!", Toast.LENGTH_SHORT).show();
            }
        }

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}