package com.example.fragmentsmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragmentsmvvm.data.Book

class BookViewModel: ViewModel() {
    private val _books = MutableLiveData<List<Book>>(listOf(
        Book("book1","author1", "description1"),
        Book("book2","author2", "description2"),
        Book("book3","author3", "description3"),
        Book("book4","author4", "description4"),
        Book("book5","author5", "description5")
    ))
    val books: LiveData<List<Book>> = _books

    private val _currentBook = MutableLiveData<Book>()
    val currentBook: LiveData<Book> = _currentBook

    fun selectBook(book: Book){
        _currentBook.value = book
    }

    fun updateBook(book: Book){
        val currentBooks = _books.value!!.toMutableList()
        val index = currentBooks.indexOfFirst { it.title == book.title }
        if(index != -1){
            currentBooks[index] = book
            _books.value = currentBooks
            _currentBook.value = book
        }
    }
}