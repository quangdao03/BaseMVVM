package com.example.basemvvm.data.retrofit


import com.example.basemvvm.data.Category
import com.example.basemvvm.data.ShapeModel
import com.example.basemvvm.data.TemplateResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("maker/templates")
    suspend fun getTemplates(): List<Category>

    @GET("maker/icon-shape-background/BG")
    suspend fun getBackground(): List<ShapeModel>


    @GET("maker/template/{category}/{template}")
    suspend fun getTemplate(
        @Path("category") category: String,
        @Path("template") template: String
    ): TemplateResponse
}
