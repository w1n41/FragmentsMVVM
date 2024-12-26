package com.example.fragmentsmvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsmvvm.data.Book
import com.example.fragmentsmvvm.fragments.BookDetailFragment
import com.example.fragmentsmvvm.fragments.BookListFragment
import com.example.fragmentsmvvm.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BookListFragment())
                .commitNow()
        }
    }

    fun onBookSelected(book: Book) {
        viewModel.selectBook(book)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, BookDetailFragment())
            .addToBackStack(null)
            .commit()
    }
}
