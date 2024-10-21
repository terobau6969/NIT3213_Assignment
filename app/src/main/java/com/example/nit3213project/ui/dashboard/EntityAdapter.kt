package com.example.nit3213project.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap1.R
import com.example.nit3213project.data.model.Entity

class EntityAdapter(
    private val entities: List<Entity>,
    private val onClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]
        holder.titleTextView.text = entity.title
        holder.authorTextView.text = entity.author

        holder.itemView.setOnClickListener {
            onClick(entity)
        }
    }

    override fun getItemCount(): Int = entities.size
}
