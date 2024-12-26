package com.example.fragmentsmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsmvvm.data.Book

class BookAdapter(
    private val books: List<Book>,
    private val onBookClicked: (Book) -> Unit
): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
        holder.itemView.setOnClickListener{onBookClicked(book)}
    }

    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val titleView: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(book: Book){
            titleView.text = book.title
        }
    }
}

