package data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by javier on 3/10/17.
 */
interface TrackITApi {

    //Se crea la estructura de las peticiones de TRACKIT
    /*@GET(Routes.URL_TRACKIT_POSITION)
    fun getPosition(): Call<ArrayList<Position>>

    @GET(Routes.URL_TRACKIT_TERMINAL_POSITION)
    fun getTerminalPosition(): Call<ArrayList<TerminalPosition>>*/

    @GET(Routes.URL_TRACKIT)
    fun getTerminalPosition(): Call<Position>
}