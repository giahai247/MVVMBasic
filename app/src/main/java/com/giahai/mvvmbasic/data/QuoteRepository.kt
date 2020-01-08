package com.giahai.mvvmbasic.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){
    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }
    fun getQuotes() = quoteDao.getQuotes()
    companion object {
        @volatile private var instance: QuoteRepository?= null
        fun getIntance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this){
            instance ?: QuoteRepository(quoteDao).also { instance = it }
        }


    }
}