package joetr.com.swipereveal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val data = arrayListOf<Data>()
    private val adapter = MainAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // generate random data
        for (i in 0..100) {
            data.add(Data(UUID.randomUUID().toString()))
        }

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        adapter.updateData(data)

        val swipeToLeftCallback = object : SwipeToLeftCallback(this, R.drawable.ic_delete_white_24dp, R.color.deleteBackground) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                removePosition(viewHolder.adapterPosition)
            }
        }
        val swipeToLeftItemTouchHelper = ItemTouchHelper(swipeToLeftCallback)
        swipeToLeftItemTouchHelper.attachToRecyclerView(list)

        val swipeToRightCallback = object : SwipeToRightCallback(this, R.drawable.ic_star_white_24dp, R.color.favoriteBackground) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                favoriteItem(viewHolder.adapterPosition)
            }
        }
        val swipeToRightItemTouchHelper = ItemTouchHelper(swipeToRightCallback)
        swipeToRightItemTouchHelper.attachToRecyclerView(list)
    }

    /**
     * Favorite item at given position
     *
     * Update adapter after
     *
     * @param adapterPosition - position to update
     */
    private fun favoriteItem(adapterPosition: Int) {
        data[adapterPosition] = data[adapterPosition].copy(liked = true)
        adapter.updateData(data)
    }

    /**
     * Remove item at given position
     *
     * Update adapter after
     *
     * @param adapterPosition - position to update
     */
    private fun removePosition(adapterPosition: Int) {
        data.removeAt(adapterPosition)
        adapter.updateData(data)
    }
}
