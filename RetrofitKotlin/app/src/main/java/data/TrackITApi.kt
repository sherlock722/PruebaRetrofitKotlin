package data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by javier on 3/10/17.
 */
interface TrackITApi {

    @GET(Routes.URL_TRACKIT)
    fun getPosition(): Call<Position>
}