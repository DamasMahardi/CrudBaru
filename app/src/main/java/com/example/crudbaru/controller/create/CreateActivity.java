package com.example.crudbaru.controller.create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.crudbaru.R;
import com.example.crudbaru.database.DataHelper;
import com.example.crudbaru.model.Karyawan;

public class CreateActivity extends AppCompatActivity {
    private DataHelper dbHelper;
    private EditText etName, etJabatan, etAlamat, etEmail, etTelphone;
    private Button btnCreate;
    private String sName, sjabatan, sAlamat, sEmail, sTelphone;
    ImageView ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbHelper = new DataHelper(this);
        etName = findViewById(R.id.et_name);
        etJabatan = findViewById(R.id.et_jabatan);
        etAlamat = findViewById(R.id.et_alamat);
        etEmail = findViewById(R.id.et_email);
        etTelphone = findViewById(R.id.et_telepon);
        btnCreate = findViewById(R.id.btn_create);
        ivBack = findViewById(R.id.mToolbarBack);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = etName.getText().toString();
                sjabatan = etJabatan.getText().toString();
                sAlamat = etAlamat.getText().toString();
                sEmail = etEmail.getText().toString();
                sTelphone = etTelphone.getText().toString();
                if (sName.equals("")) {
                    etName.requestFocus();
                    Toast.makeText(CreateActivity.this, "Tolong isi dong namanya", Toast.LENGTH_SHORT).show();
                } else {
                    if (sjabatan.equals("")) {
                        etJabatan.requestFocus();
                        Toast.makeText(CreateActivity.this, "Tolong isi terlebih dahulu jabatannya", Toast.LENGTH_SHORT).show();
                    } else {
                        if (sAlamat.equals("")){
                            etAlamat.requestFocus();
                            Toast.makeText(CreateActivity.this, "Tolong isi alamat terlebih dahulu", Toast.LENGTH_SHORT).show();
                        }else {
                            if (sEmail.equals("")){
                                etEmail.requestFocus();
                                Toast.makeText(CreateActivity.this, "Tolong isi email terlebih dahulu", Toast.LENGTH_SHORT).show();
                            }else {
                                if (sTelphone.equals("")){
                                    etTelphone.requestFocus();
                                    Toast.makeText(CreateActivity.this, "Tolong isi No telphone terlebih dahulu", Toast.LENGTH_SHORT).show();
                                }else {
                                    etName.setText("");
                                    etJabatan.setText("");
                                    etAlamat.setText("");
                                    etEmail.setText("");
                                    etTelphone.setText("");
                                    Toast.makeText(CreateActivity.this, "Create sukses", Toast.LENGTH_SHORT).show();
                                    Karyawan karyawan = new Karyawan();
                                    karyawan.setName(sName);
                                    karyawan.setJabatan(sjabatan);
                                    karyawan.setAlamat(sAlamat);
                                    karyawan.setEmail(sEmail);
                                    karyawan.setTelephone(sTelphone);
                                    dbHelper.createKaryawan(karyawan);
                                }

                            }
                        }
                    }

                }

            }
        });
    }
}