package ru.lapov.forrabitresult.listadapter

import android.view.ViewGroup
import org.jetbrains.anko.layoutInflater
import ru.lapov.forrabitresult.R
import ru.lapov.forrabitresult.adapter.DelegateAdapter
import ru.lapov.forrabitresult.models.RowItemModel

class ResultDelegate: DelegateAdapter.Delegate<RowItemModel, ResultItemHolder>() {

    override fun createViewHolder(parent: ViewGroup): ResultItemHolder {
        val view = parent.context.layoutInflater.inflate(R.layout.row, parent, false)
        return ResultItemHolder(view)
    }

    override fun bind(viewHolder: ResultItemHolder, model: RowItemModel) {
        viewHolder.bind(model)
    }

}