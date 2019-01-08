package tv.rings.data.server

import tv.rings.data.MovieData
import tv.rings.domain.datasource.MovieDataSource

class MovieServerDataSource: MovieDataSource {
    override fun requestMovieList(): MovieData {
        return MovieListRequest().execute()
    }

}