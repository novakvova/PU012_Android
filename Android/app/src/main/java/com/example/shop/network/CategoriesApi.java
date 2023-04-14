package com.example.shop.network;

import retrofit2.Call;
import retrofit2.http.GET;

import com.example.shop.dto.category.CategoryItemDTO;

import java.util.List;

public interface CategoriesApi {
    @GET("/api/categories/list")
    public Call<List<CategoryItemDTO>> list();
}
