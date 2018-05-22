package tv.rings.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tv.rings.data.Movies
import tv.rings.kotlinloops.app.R

/**
 * Created by WangBin on 22/5/18.
 */
class HomeAdapter(private val listener: ((Movies) -> Unit)? = null)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun getItemCount(): Int {
        return moviesList.count()
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder?.bind(moviesList[position])
    }

    var moviesList = mutableListOf<Movies>()
    set(value) {
        field.clear()
        moviesList.addAll(value)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder{
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_home_feed, parent, false)
        return HomeViewHolder(view)
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: Movies) = with(itemView) {

        }
    }
}