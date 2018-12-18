package tv.rings.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import tv.rings.data.Movie
import tv.rings.kotlinloops.app.R
import kotlinx.android.synthetic.main.row_home_feed.*

class MovieListAdapter(val items: List<Movie>, val itemView: Int, val itemClick: (Movie) -> Unit):
        RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(itemView, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val movie = items[position]
        holder?.imgPoster?.setImageResource(R.mipmap.wolf)
        holder?.titleView?.text= movie.title
        holder?.descriptionView?.text = movie.description
        holder?.imgPoster?.setOnClickListener{
            itemClick.invoke(movie)
        }
    }

    class ViewHolder(rootView: View):
            RecyclerView.ViewHolder(rootView) {
        val imgPoster: ImageView = rootView.findViewById(R.id.imgPoster)
        val titleView: TextView = rootView.findViewById(R.id.txtTitle)
        val descriptionView: TextView = rootView.findViewById(R.id.txtDescription)
    }
}