package com.example.api_resful_exam;

import com.example.api_resful_exam.Volume;
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

public class VolumeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VolumeAdapter volumeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        recyclerView = findViewById(R.id.recyclerViewVolumenes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener el ID de la revista seleccionada
        String journalId = getIntent().getStringExtra("journal_id");

        // Configurar Retrofit para la API de volúmenes
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://revistas.uteq.edu.ec/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RevistaApiService apiService = retrofit.create(RevistaApiService.class);

        // Llamada a la API para obtener los volúmenes de la revista seleccionada
        apiService.obtenerVolumenes(journalId).enqueue(new Callback<List<Volume>>() {
            @Override
            public void onResponse(Call<List<Volume>> call, Response<List<Volume>> response) {
                if (response.isSuccessful()) {
                    List<Volume> volumes = response.body();
                    volumeAdapter = new VolumeAdapter(volumes);
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
}
