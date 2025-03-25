package com.example.api_resful_exam;

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

public class ArticulosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticuloAdapter articuloAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);

        recyclerView = findViewById(R.id.recyclerViewArticulos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener el issue_id del Intent
        String issueId = getIntent().getStringExtra("issue_id");

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://revistas.uteq.edu.ec/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RevistaApiService apiService = retrofit.create(RevistaApiService.class);

        // Llamada a la API para obtener los artículos
        apiService.obtenerArticulos(issueId).enqueue(new Callback<List<Articulo>>() {
            @Override
            public void onResponse(Call<List<Articulo>> call, Response<List<Articulo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Articulo> articulos = response.body();
                    // Pasar el Context al adaptador
                    articuloAdapter = new ArticuloAdapter(articulos, ArticulosActivity.this);
                    recyclerView.setAdapter(articuloAdapter);
                } else {
                    Toast.makeText(ArticulosActivity.this, "Error al obtener los artículos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Articulo>> call, Throwable t) {
                Toast.makeText(ArticulosActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}