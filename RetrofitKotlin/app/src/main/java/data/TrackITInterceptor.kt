package data

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by javier on 3/10/17.
 */
class TrackITInterceptor(val apiKey: String, val cacheDuration: Int) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        //Se obtiene el request
        val request = chain.request()

        val url = request.url().newBuilder()
                .addQueryParameter("api_key", apiKey)
                .addQueryParameter("format", "json")
                .build()

        val newRequest = request.newBuilder()
                .url(url)
                .addHeader("Cache-Control", "public, max-age=$cacheDuration")
                .build()

        return chain.proceed(newRequest)
    }
}