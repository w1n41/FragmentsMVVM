package com.example.fragmentsmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentsmvvm.R
import com.example.fragmentsmvvm.viewmodel.BookViewModel

class BookEditFragment : Fragment() {
    private lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BookViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_book_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleEdit = view.findViewById<EditText>(R.id.titleEdit)
        val authorEdit = view.findViewById<EditText>(R.id.authorEdit)
        val descriptionEdit = view.findViewById<EditText>(R.id.descriptionEdit)

        viewModel.currentBook.observe(viewLifecycleOwner){ book ->
            book?.let {
                titleEdit.setText(it.title)
                authorEdit.setText(it.author)
                descriptionEdit.setText(it.descripton)
            }
        }

        view.findViewById<Button>(R.id.saveButton).setOnClickListener {
            viewModel.currentBook.value?.let { book ->
                book.title = titleEdit.text.toString()
                book.author = authorEdit.text.toString()
                book.descripton = descriptionEdit.text.toString()
                viewModel.updateBook(book)
                parentFragmentManager.popBackStack()
            }
        }
    }
}