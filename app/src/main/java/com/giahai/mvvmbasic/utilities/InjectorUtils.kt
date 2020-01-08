package com.giahai.mvvmbasic.utilities

import com.giahai.mvvmbasic.data.FakeDatabase
import com.giahai.mvvmbasic.data.QuoteRepository
import com.giahai.mvvmbasic.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getIntance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}