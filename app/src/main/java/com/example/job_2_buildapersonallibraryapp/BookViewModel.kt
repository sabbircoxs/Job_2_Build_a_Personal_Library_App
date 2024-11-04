package com.example.job_2_buildapersonallibraryapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job_2_buildapersonallibraryapp.Book
import com.example.job_2_buildapersonallibraryapp.BookRepository
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    val allBooks: LiveData<List<Book>> = repository.allBooks

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }

    fun update(book: Book) = viewModelScope.launch {
        repository.update(book)
    }

    fun delete(book: Book) = viewModelScope.launch {
        repository.delete(book)
    }

    fun searchBooks(searchQuery: String): LiveData<List<Book>> {
        return repository.searchBooks(searchQuery)
    }
}

