package ru.lapov.forrabitresult.listadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.divider.view.*
import ru.lapov.forrabitresult.models.DividerItemModel

class DividerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(model: DividerItemModel) {
        itemView.divider.text = model.title
    }
}