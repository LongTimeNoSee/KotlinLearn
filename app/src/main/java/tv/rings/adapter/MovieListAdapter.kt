package tv.rings.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import tv.rings.data.Movie
import tv.rings.kotlinloops.app.R
import kotlinx.android.synthetic.main.row_home_feed.*

class MovieListAdapter(val context: Context, var items: List<Movie>,
                       val itemView: Int, val itemClick: (Movie) -> Unit) :
        RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    fun setData(list: List<Movie>) {
        items = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(itemView, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val movie = items[position]
        with(movie) {
            Picasso.with(context).load(poster).into(holder?.imgPoster)
            holder?.titleView?.text = title
            holder?.descriptionView?.text = description
            holder?.imgPoster?.setOnClickListener {
                itemClick.invoke(movie)
            }
        }
    }

    class ViewHolder(rootView: View) :
            RecyclerView.ViewHolder(rootView) {
        val imgPoster: ImageView = rootView.findViewById(R.id.imgPoster)
        val titleView: TextView = rootView.findViewById(R.id.txtTitle)
        val descriptionView: TextView = rootView.findViewById(R.id.txtDescription)
    }
}