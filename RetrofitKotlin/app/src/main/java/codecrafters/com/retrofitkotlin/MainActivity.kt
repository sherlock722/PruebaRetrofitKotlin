package codecrafters.com.retrofitkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import data.TrackITServices

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiServices : TrackITServices = TrackITServices("111111", 200)

        apiServices.apiClient.getPosition();

    }
}
