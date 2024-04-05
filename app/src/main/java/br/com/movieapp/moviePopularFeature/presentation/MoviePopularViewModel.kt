package br.com.movieapp.moviePopularFeature.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.moviePopularFeature.domain.usecase.GetPopularMoviesUseCase
import br.com.movieapp.moviePopularFeature.presentation.state.MoviePopularState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

//      Maneira comum utilizada quando trabalhamos com XML
//    private val _uiState2 = MutableStateFlow(MoviePopularState())
//    val uiState2: StateFlow<MoviePopularState> = _uiState2.asStateFlow()

    //Compose State
    var uiState by mutableStateOf(MoviePopularState())
        private set

    init {
        val movies = getPopularMoviesUseCase.invoke()
            .cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }
}