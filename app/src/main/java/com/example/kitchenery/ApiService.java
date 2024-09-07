package com.example.kitchenery;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("filter.php?c=Seafood")
    Call<ResponseListMakanan> getListMakanan();

    @GET("lookup.php")
    Call<Makanan> getDetailMakanan(@Query("i") String i);
}
