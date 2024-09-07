package com.example.kitchenery;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Makanan> localdataset;

    public RecyclerViewAdapter(List<Makanan> dataset) {
        this.localdataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Implementasikan pembuatan ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makanan_row_item, parent, false);
        return new ViewHolder(view);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Deklarasikan komponen tampilan dalam ViewHolder
        private TextView tvNama;
        private ImageView imgview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.text_judul);
            imgview = itemView.findViewById(R.id.img_makanan);
        }

        public void bind(Makanan makanan) {
            tvNama.setText(makanan.getStrMeal());
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Implementasikan pengikatan data ke ViewHolder
        Makanan makanan = localdataset.get(position);
        holder.bind(makanan);

        String urlPoster =makanan.getStrMealThumb();
        Picasso.get()
                .load(urlPoster)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder_error)
                .into(holder.imgview);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("makanan_id",makanan.getIdMeal());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localdataset.size();
    }


}
