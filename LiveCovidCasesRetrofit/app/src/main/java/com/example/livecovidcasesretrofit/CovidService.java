package com.example.livecovidcasesretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidService {

    @GET("https://api.covid19api.com/country/India")
    Call<String>  getStats();


}
