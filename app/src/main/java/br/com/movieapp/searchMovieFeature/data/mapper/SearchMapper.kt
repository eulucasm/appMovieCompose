package br.com.movieapp.searchMovieFeature.data.mapper

import br.com.movieapp.core.data.remote.model.SearchResult
import br.com.movieapp.core.domain.model.MovieSearch
import br.com.movieapp.core.util.toPostUrl

fun List<SearchResult>.toMovieSearch() = map {
    MovieSearch(
        id = it.id,
        imageUrl = it.posterPath.toPostUrl(),
        voteAverage = it.voteAverage
    )
}