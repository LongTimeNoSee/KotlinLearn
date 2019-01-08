package tv.rings.domain.datasource

import tv.rings.data.MovieData
import tv.rings.data.server.MovieServerDataSource

class MovieProvider(private val sources: List<MovieDataSource> = SOURCES) {
    companion object {
        val SOURCES by lazy { listOf(MovieServerDataSource()) }
    }

    fun requestMovieList(): MovieData = sources.get(0).requestMovieList()

}