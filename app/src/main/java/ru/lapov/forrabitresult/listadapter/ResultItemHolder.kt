package ru.lapov.forrabitresult.listadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.row.view.*
import ru.lapov.forrabitresult.models.RowItemModel

class ResultItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(model: RowItemModel) {
        itemView.apply {
            time.text = model.time
            title.text = model.title
            coef1.text = model.coef1
            coef2.text = model.coef2
            coef3.text = model.coef3
            score.text = model.score
            result.text = model.result
        }
    }

}
