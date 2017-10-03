package data.serializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import data.TerminalPosition
import java.lang.reflect.Type

/**
 * Created by javier on 3/10/17.
 */
class TerminalPositionSerializer : JsonDeserializer<TerminalPosition> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): TerminalPosition {

        //Para parsear se necesita una instancia de GSON
        var gson = Gson()

        //Se crea un objeto Position a partir del json y de la clase del módelo que lo representa
        val terminalPosition = gson.fromJson(json, TerminalPosition::class.java)

        return terminalPosition
    }}


