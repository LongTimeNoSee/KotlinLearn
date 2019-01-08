package tv.rings.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import tv.rings.BaseFragment
import tv.rings.PlayerApp
import tv.rings.adapter.MovieListAdapter
import tv.rings.data.Movie
import tv.rings.domain.commands.RequestMovieCommand
import tv.rings.extensions.DelegatesExt.preference
import tv.rings.kotlinloops.app.R
import tv.rings.toast

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
                val movieSource = RequestMovieCommand().execute()
                movieSource?.movies
            }
            updateUI(result.await()!!)
        }
    }

    fun updateUI(list: List<Movie>) {
        movieListAdapter.setData(list)
    }

    fun initView() {
        var list: List<Movie> = ArrayList()

        rvMovies.layoutManager = LinearLayoutManager(this!!.activity)
        movieListAdapter = MovieListAdapter(context!!, list, R.layout.row_home_feed) {
            toast("This is a movie:" + it.title)
        }

        rvMovies.adapter = movieListAdapter
    }
}