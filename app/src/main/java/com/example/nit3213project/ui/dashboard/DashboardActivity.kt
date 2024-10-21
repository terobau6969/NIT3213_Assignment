package com.example.nit3213project.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ap1.R
import com.example.nit3213project.data.model.DashboardResponse
import com.example.nit3213project.data.model.Entity
import com.example.nit3213project.data.network.ApiService
import com.example.nit3213project.ui.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    private lateinit var recyclerView: RecyclerView
    private lateinit var entityAdapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val keypass = intent.getStringExtra("KEYPASS")

        if (keypass != null) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(this, "Keypass is missing!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        apiService.getDashboardData(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    val entities = response.body()?.entities ?: emptyList()

                    if (entities.isNotEmpty()) {
                        entityAdapter = EntityAdapter(entities) { entity ->
                            val intent = Intent(this@DashboardActivity, DetailsActivity::class.java)
                            intent.putExtra("ENTITY", entity)  // entity is of type Entity
                            startActivity(intent)
                        }

                        recyclerView.adapter = entityAdapter
                    } else {
                        Toast.makeText(this@DashboardActivity, "No items to display", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load dashboard data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
