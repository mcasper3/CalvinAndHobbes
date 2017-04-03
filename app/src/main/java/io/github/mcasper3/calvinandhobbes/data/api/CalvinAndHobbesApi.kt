package io.github.mcasper3.calvinandhobbes.data.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CalvinAndHobbesApi {
    @GET("calvinandhobbes/{year}/{month}/{day}")
    fun getComic(@Path("year") year: String, @Path("month") month: String, @Path("day") day: String): Observable<ResponseBody>

    object Creator {
        fun create(): CalvinAndHobbesApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://www.gocomics.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create<CalvinAndHobbesApi>(CalvinAndHobbesApi::class.java)
        }
    }
}
