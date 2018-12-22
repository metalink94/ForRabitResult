package ru.lapov.forrabitresult.adapter

interface AdapterAction<in M, in H : RecyclerView.ViewHolder> {
    fun bind(model: M, viewHolder: H)
}

class OnRootClickAdapterAction<in M, in H : RecyclerView.ViewHolder>(val onClickListener: (M)-> Unit) : AdapterAction<M, H> {
    override fun bind(model: M, viewHolder: H) {
        viewHolder.itemView.setOnClickListener { onClickListener.invoke(model) }
    }
}