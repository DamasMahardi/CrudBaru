package com.example.crudbaru.controller.update;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudbaru.R;
import com.example.crudbaru.database.DataHelper;

public class UpdateActivity extends AppCompatActivity {
    private DataHelper database;
    private String sId, sName, sJabatan, sAlamat, sEmail, sTelephone;
    private EditText etId, etName, etJabatan, etAlamat, etEmail, etTelephone;
    private Button btnShow, btnUpdate;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new DataHelper(this);

        etId = findViewById(R.id.et_showId);
        etName = findViewById(R.id.et_Name);
        etJabatan = findViewById(R.id.et_Jabatan);
        etAlamat = findViewById(R.id.et_Alamat);
        etEmail= findViewById(R.id.et_Email);
        etTelephone = findViewById(R.id.et_NoTelpohone);
        btnShow = findViewById(R.id.btn_Show);
        btnUpdate = findViewById(R.id.btn_Update);
        ivBack = findViewById(R.id.iv_ToolbarBack);

        etName.setText(sName);
        etJabatan.setText(sJabatan);
        etAlamat.setText(sAlamat);
        etEmail.setText(sEmail);
        etTelephone.setText(sTelephone);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sName = etName.getText().toString();
                sJabatan= etJabatan.getText().toString();
                sAlamat = etAlamat.getText().toString();
                sEmail = etEmail.getText().toString();
                sTelephone = etTelephone.getText().toString();
                if (sName.equals("")){
                    etName.requestFocus();
                    Toast.makeText(UpdateActivity.this, "Tolong isi nama terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else {
                    if (sJabatan.equals("")){
                        etJabatan.requestFocus();
                        Toast.makeText(UpdateActivity.this, "Tolong isi jabatan terlebih dahulu", Toast.LENGTH_SHORT).show();
                    }else {
                        if (sAlamat.equals("")){
                            etAlamat.requestFocus();
                            Toast.makeText(UpdateActivity.this, "Tolong isi Alamat terlebih dahulu", Toast.LENGTH_SHORT).show();
                        }else {
                            if (sEmail.equals("")){
                                etEmail.requestFocus();
                                Toast.makeText(UpdateActivity.this, "Tolong isi Email terlebih dahulu", Toast.LENGTH_SHORT).show();
                            }else {
                                if (sTelephone.equals("")){
                                    etTelephone.requestFocus();
                                    Toast.makeText(UpdateActivity.this, "Tolong isi Telephone terlebih dahulu", Toast.LENGTH_SHORT).show();
                                }else {
                                    long l = Long.parseLong(sId);
                                    database.updateKaryawan(l,sName,sJabatan,sAlamat,sEmail,sTelephone);
                                    Toast.makeText(UpdateActivity.this, "Data sukses di Update", Toast.LENGTH_SHORT).show();
                                    etId.setText("");
                                    etName.setText("");
                                    etJabatan.setText("");
                                    etAlamat.setText("");
                                    etEmail.setText("");
                                    etTelephone.setText("");
                                }
                            }
                        }
                    }
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sId = etId.getText().toString();
                if (sId.equals("")){
                    Toast.makeText(UpdateActivity.this, "Tolong isi Id terlebih dahulu", Toast.LENGTH_SHORT).show();
                    etId.requestFocus();
                }else {
                    try {
                        long  show = Long.parseLong(sId);
                        sName = database.getName(show);
                        sJabatan = database.getJabatan(show);
                        sAlamat =database.getAlamat(show);
                        sEmail = database.getEmail(show);
                        sTelephone =database.getTelephone(show);
                        etName.setText(sName);
                        etJabatan.setText(sJabatan);
                        etAlamat.setText(sAlamat);
                        etEmail.setText(sEmail);
                        etTelephone.setText(sTelephone);
                    }catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}