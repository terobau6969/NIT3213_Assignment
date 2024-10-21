package com.example.nit3213project.ui.details

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ap1.R
import com.example.nit3213project.data.model.Entity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val entity = intent.getParcelableExtra<Entity>("ENTITY")

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val authorTextView = findViewById<TextView>(R.id.authorTextView)
        val genreTextView = findViewById<TextView>(R.id.genreTextView)
        val publicationYearTextView = findViewById<TextView>(R.id.publicationYearTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        entity?.let {
            titleTextView.text = it.title
            authorTextView.text = it.author
            genreTextView.text = it.genre
            publicationYearTextView.text = it.publicationYear.toString()
            descriptionTextView.text = it.description
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
