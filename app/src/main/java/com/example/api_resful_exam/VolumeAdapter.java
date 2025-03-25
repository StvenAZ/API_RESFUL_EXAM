package com.example.api_resful_exam;

import android.content.Context;
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
    private final Context context;
    private final OnVolumeClickListener listener;

    // Interfaz para manejar clics
    public interface OnVolumeClickListener {
        void onVolumeClick(Volume volume);
    }

    // Constructor actualizado
    public VolumeAdapter(List<Volume> volumes, Context context, OnVolumeClickListener listener) {
        this.volumes = volumes;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VolumeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.volumen_item, parent, false);
        return new VolumeViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumeViewHolder holder, int position) {
        Volume volume = volumes.get(position);
        holder.bind(volume); // Usamos un método bind para configurar las vistas
    }

    @Override
    public int getItemCount() {
        return volumes.size();
    }

    // ViewHolder con manejo de clics
    public static class VolumeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView volumeCover;
        TextView volumeTitle;
        TextView doiTextView;
        private final OnVolumeClickListener listener;
        private Volume volume;

        public VolumeViewHolder(View itemView, OnVolumeClickListener listener) {
            super(itemView);
            this.listener = listener;
            volumeCover = itemView.findViewById(R.id.volumeCover);
            volumeTitle = itemView.findViewById(R.id.volumeTitle);
            doiTextView = itemView.findViewById(R.id.doiTextView);
            itemView.setOnClickListener(this); // Habilitamos el clic en el ítem
        }

        public void bind(Volume volume) {
            this.volume = volume;
            volumeTitle.setText(volume.getTitle());
            doiTextView.setText(volume.getDoi());
            Picasso.get().load(volume.getCover()).into(volumeCover);
        }

        @Override
        public void onClick(View v) {
            if (listener != null && volume != null) {
                listener.onVolumeClick(volume); // Notificamos al listener con el volumen seleccionado
            }
        }
    }
}