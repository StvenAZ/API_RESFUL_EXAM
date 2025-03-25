package com.example.api_resful_exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class VolumeActivity extends AppCompatActivity implements VolumeAdapter.OnVolumeClickListener {

    private RecyclerView recyclerView;
    private VolumeAdapter volumeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerViewVolumenes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener el ID de la revista desde el Intent
        String journalId = getIntent().getStringExtra("journal_id");

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://revistas.uteq.edu.ec/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear el servicio de la API
        RevistaApiService apiService = retrofit.create(RevistaApiService.class);

        // Realizar la llamada a la API para obtener los volúmenes
        apiService.obtenerVolumenes(journalId).enqueue(new Callback<List<Volume>>() {
            @Override
            public void onResponse(Call<List<Volume>> call, Response<List<Volume>> response) {
                if (response.isSuccessful()) {
                    List<Volume> volumes = response.body();
                    // Crear el adaptador con los tres parámetros necesarios
                    volumeAdapter = new VolumeAdapter(volumes, VolumeActivity.this, VolumeActivity.this);
                    recyclerView.setAdapter(volumeAdapter);
                } else {
                    Toast.makeText(VolumeActivity.this, "Error al obtener los volúmenes", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Volume>> call, Throwable t) {
                Toast.makeText(VolumeActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Manejar el clic en un volumen
    @Override
    public void onVolumeClick(Volume volume) {
        Intent intent = new Intent(this, ArticulosActivity.class);
        intent.putExtra("issue_id", volume.getIssue_id());
        startActivity(intent);
    }
}