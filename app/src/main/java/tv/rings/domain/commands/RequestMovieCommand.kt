package tv.rings.domain.commands

import tv.rings.data.MovieData
import tv.rings.domain.datasource.MovieProvider

class RequestMovieCommand(private val movieProvider: MovieProvider = MovieProvider()):
        Command<MovieData> {
    override fun execute(): MovieData = movieProvider.requestMovieList()
}