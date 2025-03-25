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

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevistaViewHolder> {

    private List<Revista> revistas;

    public RevistaAdapter(List<Revista> revistas) {
        this.revistas = revistas;
    }

    @Override
    public RevistaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_revista, parent, false);
        return new RevistaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {
        final Revista revista = revistas.get(position);  // Asegúrate de que 'revistas' esté declarada
        holder.nameTextView.setText(revista.getName());

        // Convertir el texto HTML a texto plano, usando Html.fromHtml para versiones previas a Android N
        String description;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            description = Html.fromHtml(revista.getDescription(), Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            description = Html.fromHtml(revista.getDescription()).toString();
        }
        holder.descriptionTextView.setText(description);

        // Usar Picasso para cargar la imagen desde la URL
        Picasso.get().load(revista.getPortada()).into(holder.logoImageView);

        // Redirigir a la actividad de volúmenes cuando se hace clic en la revista
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), VolumeActivity.class);
            intent.putExtra("journal_id", revista.getJournal_id());  // Pasar el ID de la revista
            v.getContext().startActivity(intent);  // Asegúrate de usar el contexto correcto
        });
    }

    @Override
    public int getItemCount() {
        return revistas.size();
    }

    public static class RevistaViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImageView;
        TextView nameTextView;
        TextView descriptionTextView;

        public RevistaViewHolder(View itemView) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.logoImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView); // Sin abreviatura
        }
    }
}