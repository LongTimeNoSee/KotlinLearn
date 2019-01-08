package tv.rings.data.server

import com.google.gson.Gson
import tv.rings.data.MovieData
import java.net.URL

class MovieListRequest(val gson: Gson = Gson()) {
    companion object {
        private const val MOVIEW_LIST_URL = "https://my-json-server.typicode" +
                ".com/burhanrashid52/YoutubeAnimation/movieslist"
    }

    fun execute(): MovieData {
        val movieDataStr = URL(MOVIEW_LIST_URL).readText()
        return gson.fromJson(movieDataStr, MovieData::class.java)
    }
}