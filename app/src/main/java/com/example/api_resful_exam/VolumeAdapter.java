package com.example.api_resful_exam;

import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VolumeAdapter extends RecyclerView.Adapter<VolumeAdapter.VolumeViewHolder> {

    private final List<Volume> volumes;

    public VolumeAdapter(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @NonNull
    @Override
    public VolumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.volumen_item, parent, false);
        return new VolumeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumeViewHolder holder, int position) {
        Volume volume = volumes.get(position);
        holder.volumeTitle.setText(volume.getTitle());

        // Convertir el texto HTML a texto plano
        String description = Html.fromHtml(volume.getDoi()).toString();  // Asegúrate de que esto sea correcto para el DOI
        holder.doiTextView.setText(description);

        // Usar Picasso para cargar la imagen desde la URL
        Picasso.get().load(volume.getCover()).into(holder.volumeCover);


    }

    @Override
    public int getItemCount() {
        return volumes.size();
    }

    public static class VolumeViewHolder extends RecyclerView.ViewHolder {
        ImageView volumeCover;
        TextView volumeTitle;
        TextView doiTextView;

        public VolumeViewHolder(View itemView) {
            super(itemView);
            volumeCover = itemView.findViewById(R.id.volumeCover);
            volumeTitle = itemView.findViewById(R.id.volumeTitle);
            doiTextView = itemView.findViewById(R.id.doiTextView);
        }
    }
}
