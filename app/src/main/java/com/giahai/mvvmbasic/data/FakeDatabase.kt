package com.giahai.mvvmbasic.data

class FakeDatabase private constructor(){
    var quoteDao = FakeQuoteDao()
    private set
    companion object{
        @volatile private var instance: FakeDatabase? = null
        fun getInstance() = instance ?: synchronized(this){
            instance ?:FakeDatabase().also { instance=it }
        }
    }
}

annotation class volatile
