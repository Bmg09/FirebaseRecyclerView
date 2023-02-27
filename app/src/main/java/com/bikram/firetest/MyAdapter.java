package com.bikram.firetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<ProductModel,MyAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     */
    public MyAdapter(@NonNull FirebaseRecyclerOptions<ProductModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ProductModel model) {
        holder.medicineName.setText(model.getMedname());
        holder.medicinePrice.setText(model.getPrice());
        holder.mfgdate.setText(model.getMfgdate());
        holder.expdate.setText(model.getExpdate());
        holder.mfgname.setText(model.getMfgname());
        holder.medicinecategory.setText(model.getCategories());
        Glide.with(holder.imageView.getContext()).load(model.getFileurl()).into(holder.imageView);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView,rximage;
        TextView medicineName, medicinePrice, mfgname,mfgdate ,expdate,medicinecategory;

        public myViewHolder(@NonNull View itemView) {
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
