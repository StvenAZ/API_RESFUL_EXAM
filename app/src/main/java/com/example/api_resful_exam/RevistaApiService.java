package com.example.api_resful_exam;

import com.example.api_resful_exam.Volume;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RevistaApiService {
    @GET("ws/journals.php")
    Call<List<Revista>> obtenerRevistas();

    @GET("ws/issues.php")
    Call<List<Volume>> obtenerVolumenes(@Query("j_id") String journalId);

}