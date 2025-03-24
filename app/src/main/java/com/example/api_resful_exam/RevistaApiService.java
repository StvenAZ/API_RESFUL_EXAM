package com.example.api_resful_exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RevistaApiService {
    @GET("ws/journals.php")  // Endpoint que devuelve las revistas
    Call<List<Revista>> obtenerRevistas();  // Retorna una lista de objetos 'Revista'
}
