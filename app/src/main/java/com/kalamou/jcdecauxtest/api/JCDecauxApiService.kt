package com.kalamou.jcdecauxtest.api

import com.kalamou.jcdecauxtest.model.StationsItem
import com.kalamou.jcdecauxtest.utils.API_KEY
import com.kalamou.jcdecauxtest.utils.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface JCDecauxApiService {

    @GET("stations?position?")
    suspend fun getStations(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<List<StationsItem>>
}


object JCDecauxApi {
    val retrofitService: JCDecauxApiService by lazy { retrofit.create(JCDecauxApiService::class.java) }
}
