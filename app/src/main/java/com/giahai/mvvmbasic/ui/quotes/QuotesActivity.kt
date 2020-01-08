package com.giahai.mvvmbasic.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.giahai.mvvmbasic.R
import com.giahai.mvvmbasic.data.Quote
import com.giahai.mvvmbasic.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiallzeUI()
    }
    private fun initiallzeUI(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory).get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {
            quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
            button_add_quote.setOnClickListener {
                val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
                viewModel.addQuote(quote)
                editText_quote.setText("")
                editText_author.setText("")
            }
        })
    }
}
