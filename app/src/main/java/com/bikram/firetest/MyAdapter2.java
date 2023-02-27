package com.bikram.firetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
    List<ProductModel> productModels;
    Context context;
    public MyAdapter2(Context context, List<ProductModel> productModels) {
        this.productModels = productModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.ViewHolder holder, int position) {
        final ProductModel model = productModels.get(position);
        holder.medicineName.setText(model.getMedname());
        holder.medicinePrice.setText(model.getPrice());
        holder.mfgdate.setText(model.getMfgdate());
        holder.expdate.setText(model.getExpdate());
        holder.mfgname.setText(model.getMfgname());
        holder.medicinecategory.setText(model.getCategories());
        Glide.with(holder.imageView.getContext()).load(model.getFileurl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,rximage;
        TextView medicineName, medicinePrice, mfgname,mfgdate ,expdate,medicinecategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rximage = itemView.findViewById(R.id.imageView2);
            imageView = itemView.findViewById(R.id.imageView);
            medicineName = itemView.findViewById(R.id.medicine_name);
            medicinePrice = itemView.findViewById(R.id.Price);
            mfgname = itemView.findViewById(R.id.mfgName);
            mfgdate = itemView.findViewById(R.id.mfgDate);
            expdate = itemView.findViewById(R.id.expdate);
            medicinecategory = itemView.findViewById(R.id.category);
        }
    }
}
