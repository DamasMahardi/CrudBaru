package com.example.crudbaru.controller.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.crudbaru.R;
import com.example.crudbaru.controller.create.CreateActivity;
import com.example.crudbaru.controller.delete.DeleteActivity;
import com.example.crudbaru.controller.read.ReadActivity;
import com.example.crudbaru.controller.update.UpdateActivity;

public class MainActivity extends AppCompatActivity {
    ImageView mCreate, mUpdate, mRead,mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUpdate = findViewById(R.id.iv_mUpdate);
        mCreate = findViewById(R.id.iv_mCreate);
        mRead = findViewById(R.id.iv_mRead);
        mDelete = findViewById(R.id.iv_mDelete);
        onClick();

    }
    private void onClick() {
            mCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                    startActivity(intent);
                }
            });
            mUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                    startActivity(intent);
                }
            });

            mRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                    startActivity(intent);
                }
            });

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                    startActivity(intent);
                }
            });

        }
        }



