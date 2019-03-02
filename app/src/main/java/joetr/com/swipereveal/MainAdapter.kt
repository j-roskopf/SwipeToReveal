package joetr.com.swipereveal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_item.view.*

class MainAdapter(private val data: ArrayList<Data>) : RecyclerView.Adapter<MainAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainAdapterViewHolder(parent.inflate(R.layout.data_item, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateData(newData: List<Data>) {
        val result = DiffUtil.calculateDiff(ItemDiffUtil(data, newData), false)
        this.data.clear()
        this.data.addAll(newData)
        result.dispatchUpdatesTo(this)
    }
}

class MainAdapterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(data: Data) {
        view.item.text = data.text
        view.icon.isVisible = data.liked
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
