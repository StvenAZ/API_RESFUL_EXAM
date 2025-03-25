package com.example.api_resful_exam;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ArticuloAdapter extends RecyclerView.Adapter<ArticuloAdapter.ArticuloViewHolder> {

    private final List<Articulo> articulos;
    private final Context context;

    public ArticuloAdapter(List<Articulo> articulos, Context context) {
        this.articulos = articulos;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticuloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo, parent, false);
        return new ArticuloViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticuloViewHolder holder, int position) {
        Articulo articulo = articulos.get(position);
        holder.titleTextView.setText(articulo.getTitle());
        holder.sectionTextView.setText(articulo.getSection());
        holder.doiTextView.setText(articulo.getDoi());

        // Configurar el botón de descarga
        holder.downloadPdfButton.setOnClickListener(v -> descargarPdf(articulo.getPdfUrl(), articulo.getTitle()));

        // Configurar el botón HTML
        holder.htmlButton.setOnClickListener(v -> {
            String doiUrl = "https://doi.org/" + articulo.getDoi(); // URL del DOI
            // Abrir el DOI en un navegador
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(doiUrl));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public static class ArticuloViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, sectionTextView, doiTextView;
        Button downloadPdfButton, htmlButton;

        public ArticuloViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            sectionTextView = itemView.findViewById(R.id.sectionTextView);
            doiTextView = itemView.findViewById(R.id.doiTextView);
            downloadPdfButton = itemView.findViewById(R.id.downloadPdfButton);
            htmlButton = itemView.findViewById(R.id.htmlButton);  // Nuevo botón HTML
        }
    }

    private void descargarPdf(String url, String fileName) {
        if (url == null || url.isEmpty()) {
            Toast.makeText(context, "No se encontró el PDF", Toast.LENGTH_SHORT).show();
            return;
        }

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setTitle(fileName + ".pdf");
        request.setDescription("Descargando PDF...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName + ".pdf");

        try {
            downloadManager.enqueue(request);
            Toast.makeText(context, "Descarga iniciada", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
