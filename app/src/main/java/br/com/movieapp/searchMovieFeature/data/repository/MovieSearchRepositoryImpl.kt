package br.com.movieapp.searchMovieFeature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.core.domain.model.MovieSearch
import br.com.movieapp.searchMovieFeature.domain.repository.MovieSearchRepository
import br.com.movieapp.searchMovieFeature.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MovieSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieSearchRemoteDataSource
) : MovieSearchRepository {
    override fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { remoteDataSource.getSearchMoviePagingSource(query = query) }
        ).flow
    }
}