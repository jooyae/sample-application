package org.android.daangngallery.data.network

import io.reactivex.rxjava3.core.Single
import org.android.daangngallery.data.dto.Picsum
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("/v2/list")
    fun getPicsumImage(
        @Query("page") page: Int,
        @Query("limit") limit : Int
    ) : Single<List<Picsum>>


    @GET("/id/{id}/info")
    fun getSpecificPicture(
        @Path("id") id: Int
    ): Single<Picsum>
}