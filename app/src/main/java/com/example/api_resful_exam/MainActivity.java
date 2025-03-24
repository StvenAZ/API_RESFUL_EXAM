package com.example.api_resful_exam;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;
import androidx.recyclerview.widget.DividerItemDecoration;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RevistaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);  // RecyclerView en tu layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // Configura un LinearLayoutManager
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Crea la instancia de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://revistas.uteq.edu.ec/")  // URL base del API
                .addConverterFactory(GsonConverterFactory.create())  // Usamos Gson para convertir el JSON en objetos
                .build();

        // Crea el servicio de Retrofit
        RevistaApiService apiService = retrofit.create(RevistaApiService.class);

        // Llamada a la API
        apiService.obtenerRevistas().enqueue(new Callback<List<Revista>>() {
            @Override
            public void onResponse(Call<List<Revista>> call, Response<List<Revista>> response) {
                if (response.isSuccessful()) {
                    // Si la respuesta es exitosa, obtenemos las revistas
                    List<Revista> revistas = response.body();
                    adapter = new RevistaAdapter(revistas);  // Crear el adaptador con las revistas obtenidas
                    recyclerView.setAdapter(adapter);  // Asignar el adaptador al RecyclerView
                } else {
                    Toast.makeText(MainActivity.this, "Error al obtener los datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Revista>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
