package tv.rings.data

data class MovieSource(val response: MovieData)

data class MovieData(val status: Int, val source: String, val movies: List<Movie>)