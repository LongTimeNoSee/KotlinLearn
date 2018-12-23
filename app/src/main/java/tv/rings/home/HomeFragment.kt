package tv.rings.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import tv.rings.BaseFragment
import tv.rings.adapter.MovieListAdapter
import tv.rings.data.Movie
import tv.rings.kotlinloops.app.R
import tv.rings.toast

class HomeFragment : BaseFragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }


    fun initView() {
        var list: List<Movie> = listOf(
                Movie("https://www.movieartarena.com/imgs/bladerunner2049ff.jpg", "Black " +
                        "runner", "This is a very good movie"),
                Movie("https://imgc.allpostersimages.com/img/print/posters/teen-wolf-official-movie-poster-print_a-G-8848874-0.jpg"
                , "J-fox", "A very rubbish movie"),
                Movie("https://www.movieartarena.com/imgs/bladerunner2049ff.jpg", "Black " +
                "runner", "This is a very good movie"),
                Movie("https://imgc.allpostersimages.com/img/print/posters/teen-wolf-official-movie-poster-print_a-G-8848874-0.jpg"
                        , "J-fox", "A very rubbish movie")
        )

        rvMovies.layoutManager = LinearLayoutManager(activity)
        rvMovies.adapter = MovieListAdapter(list, R.layout.row_home_feed) {
            toast("This is a movie:" + it.title)
        }


    }
}