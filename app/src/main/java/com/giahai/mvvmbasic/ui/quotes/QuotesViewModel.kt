package com.giahai.mvvmbasic.ui.quotes

import androidx.lifecycle.ViewModel
import com.giahai.mvvmbasic.data.Quote
import com.giahai.mvvmbasic.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}