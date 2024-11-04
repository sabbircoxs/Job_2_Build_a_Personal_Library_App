package com.example.job_2_buildapersonallibraryapp

import androidx.lifecycle.LiveData
import com.example.job_2_buildapersonallibraryapp.Book
import com.example.job_2_buildapersonallibraryapp.BookDao

class BookRepository(private val bookDao: BookDao) {
    val allBooks: LiveData<List<Book>> = bookDao.getAllBooks()

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    suspend fun update(book: Book) {
        bookDao.update(book)
    }

    suspend fun delete(book: Book) {
        bookDao.delete(book)
    }

    fun searchBooks(searchQuery: String): LiveData<List<Book>> {
        return bookDao.searchBooks("%$searchQuery%")
    }
}
