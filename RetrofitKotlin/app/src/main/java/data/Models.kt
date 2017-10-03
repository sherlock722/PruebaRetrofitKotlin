package data

import java.util.*

/**
 * Created by javier on 3/10/17.
 */
data class Position (

        var positionId:String?=null,
        var positionTimeStamp: Date?=null,
        var latitude:Double?=null,
        var longitude:Double?=null)


data class TerminalPosition (
        var fqTerminalID:String?=null,
        var name:String?=null,
        var positionTimeStamp: Date?=null,
        var latitude:Double?=null,
        var longitude:Double?=null)