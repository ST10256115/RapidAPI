package com.st_10256115.rapidapi.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.st_10256115.products.data.ProductRepository
import com.st_10256115.products.network.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class UiState(
    val query: String = "laptop",
    val isLoading: Boolean = false,
    val results: List<ProductItem> = emptyList(),
    val error: String? = null
)

class ProductViewModel(
    private val repo: ProductRepository = ProductRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state

    fun updateQuery(q: String) { _state.value = _state.value.copy(query = q) }

    fun search() {
        val q = _state.value.query.trim()
        if (q.isEmpty()) return
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            runCatching { repo.search(q) }
                .onSuccess { _state.value = _state.value.copy(isLoading = false, results = it) }
                .onFailure { _state.value = _state.value.copy(isLoading = false, error = it.message) }
        }
    }
}
