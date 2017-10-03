package data

import com.google.gson.GsonBuilder
import data.serializer.PositionSerializer
import data.serializer.TerminalPositionSerializer
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by javier on 3/10/17.
 */
class TrackITServices (apiKey : String, cacheDuration: Int){


    val apiClient : TrackITApi

    init {

        //Especificar una configuración especifica del gson
        val gson = GsonBuilder()
                .registerTypeAdapter(Position::class.java, PositionSerializer())
                .registerTypeAdapter(TerminalPosition::class.java, TerminalPositionSerializer())
                .create()


        //Se crea un cliente okhttp (OkHttpClient) para añadir interceptores
        //y luego se añade a la configuracion del cliente que hace las peticiones
        val client = OkHttpClient().newBuilder()
                .addInterceptor(TrackITInterceptor(apiKey, cacheDuration))
                .build()


        //Configuracion del cliente para hacer las peticiones
        //Se pasa en el GsonConverterFactory el gson con una configurción especifica
        val apiClientConfig = Retrofit.Builder() //Metodo estático de la clase Retrofit
                .baseUrl(Routes.BASE_URL_TRACKIT) //Base URL
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)) //Convertidor para parsear las respuestas(GSON)
                .build() //Se construye

        //Indicar cual es la API a la que se va a comunicar (TrackITApi)
        // y se construye y crea la instancia del cliente (apiClient)
        apiClient = apiClientConfig.create(TrackITApi::class.java)


    }

}