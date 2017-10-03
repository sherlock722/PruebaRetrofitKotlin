package data.serializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import data.Position
import java.lang.reflect.Type

/**
 * Created by javier on 3/10/17.
 */
class PositionSerializer : JsonDeserializer<Position> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Position {

        //Para parsear se necesita una instancia de GSON
        var gson = Gson()

        //Se crea un objeto Position a partir del json y de la clase del módelo que lo representa
        val position = gson.fromJson(json, Position::class.java)

        return position
    }
}