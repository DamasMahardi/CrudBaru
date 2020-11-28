package com.example.crudbaru.controller.read;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudbaru.R;
import com.example.crudbaru.model.Karyawan;

import java.util.List;

public class KaryawanAdapter  extends RecyclerView.Adapter<KaryawanAdapter.ViewHolder> {
    private List<Karyawan> itemListSKaryawan;
    Context context;

    public KaryawanAdapter(Context context, List<Karyawan> itemListSKaryawan){
        this.context = context;
        this.itemListSKaryawan = itemListSKaryawan;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KaryawanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_karyawan, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KaryawanAdapter.ViewHolder holder,final int position) {
        Karyawan karyawan = itemListSKaryawan.get(position);
        holder.id.setText(karyawan.getId());
        holder.name.setText(karyawan.getName());
        holder.jabatan.setText(karyawan.getJabatan());
        holder.alamat.setText(karyawan.getAlamat());
        holder.email.setText(karyawan.getEmail());
        holder.telephone.setText(karyawan.getTelephone());


    }

    @Override
    public int getItemCount() {
        return itemListSKaryawan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, jabatan, alamat, email, telephone;
        ImageView ivProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name);
            jabatan = itemView.findViewById(R.id.tv_jabatan);
            alamat = itemView.findViewById(R.id.tv_alamat);
            email = itemView.findViewById(R.id.tv_email);
            telephone = itemView.findViewById(R.id.tv_telephone);

        }
    }


}
