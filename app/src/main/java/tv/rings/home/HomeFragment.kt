package tv.rings.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import tv.rings.BaseFragment
import tv.rings.PlayerApp
import tv.rings.adapter.MovieListAdapter
import tv.rings.data.Movie
import tv.rings.data.MovieData
import tv.rings.data.MovieSource
import tv.rings.extensions.DelegatesExt.preference
import tv.rings.kotlinloops.app.R
import tv.rings.toast
import java.net.URL

class HomeFragment : BaseFragment() {

    private val index: Long by preference(PlayerApp.instance(), "index", 0)

    companion object {
        val TAG = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    private lateinit var movieListAdapter: MovieListAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initView()
    }

    fun initData() {
        async(UI) {
            val result = bg {
                val response = URL("https://my-json-server.typicode" +
                        ".com/burhanrashid52/YoutubeAnimation/movieslist").readText()
                Log.d(TAG, "response:$response")
                val resultGson = Gson()
                val movieSource = resultGson.fromJson(response, MovieData::class.java)
                movieSource?.movies
            }

            updateUI(result.await()!!)
        }
    }

    fun updateUI(list: List<Movie>) {
        movieListAdapter.setData(list)
    }

    fun initView() {
        var list: List<Movie> = listOf(
                Movie("https://www.movieartarena.com/imgs/bladerunner2049ff.jpg", "Black " +
                        "runner", "This is a very good movie", "https://www.baidu.com"),
                Movie("https://imgc.allpostersimages.com/img/print/posters/teen-wolf-official-movie-poster-print_a-G-8848874-0.jpg"
                        , "J-fox", "A very rubbish movie", "https://www.baidu.com"),
                Movie("https://www.movieartarena.com/imgs/bladerunner2049ff.jpg", "Black " +
                        "runner", "This is a very good movie", "https://www.baidu.com"),
                Movie("https://imgc.allpostersimages.com/img/print/posters/teen-wolf-official-movie-poster-print_a-G-8848874-0.jpg"
                        , "J-fox", "A very rubbish movie", "https://www.baidu.com")
        )

        rvMovies.layoutManager = LinearLayoutManager(this!!.activity)
        movieListAdapter = MovieListAdapter(list, R.layout.row_home_feed) {
            toast("This is a movie:" + it.title)
        }

        rvMovies.adapter = movieListAdapter
    }
}