package com.example.crudbaru.controller.delete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.crudbaru.R;
import com.example.crudbaru.database.DataHelper;

public class DeleteActivity extends AppCompatActivity {
    DataHelper databasae;
    private EditText etId;
    private Button btnDelete;
    private ImageView ivback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        databasae = new DataHelper(this);
        etId = findViewById(R.id.et_id);
        btnDelete = findViewById(R.id.btn_Delete);
        ivback = findViewById(R.id.iv_ToolbarBack);

        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                if (TextUtils.isEmpty(id)){
                    etId.requestFocus();
                    Toast.makeText(DeleteActivity.this, "Tolong isi number id terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }
                int deleteRows = databasae.deleteKaryawan(etId.getText().toString());
                if (deleteRows > 0){
                    etId.setText("");
                    finish();
                }else {
                    Toast.makeText(DeleteActivity.this, "Data tidak terhapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}