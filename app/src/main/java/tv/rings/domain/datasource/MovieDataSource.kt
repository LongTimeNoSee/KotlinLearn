package tv.rings.domain.datasource

import tv.rings.data.MovieData

interface MovieDataSource {

    fun requestMovieList(): MovieData

}