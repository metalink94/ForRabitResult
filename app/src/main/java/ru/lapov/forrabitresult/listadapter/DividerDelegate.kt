package ru.lapov.forrabitresult.listadapter

import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater
import ru.lapov.forrabitresult.R
import ru.lapov.forrabitresult.adapter.DelegateAdapter
import ru.lapov.forrabitresult.models.DividerItemModel

class DividerDelegate: DelegateAdapter.Delegate<DividerItemModel, DividerViewHolder>() {

    override fun createViewHolder(parent: ViewGroup): DividerViewHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.divider, parent, false)
        return DividerViewHolder(view)
    }

    override fun bind(viewHolder: DividerViewHolder, model: DividerItemModel) {
        viewHolder.bind(model)
    }

}