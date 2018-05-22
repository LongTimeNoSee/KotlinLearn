package tv.rings.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by WangBin on 22/5/18.
 */
@Entity
data class Movies(
        @field:SerializedName("id")
        @PrimaryKey
        val id: Int,

        @field:SerializedName("videoUrl")
        val videoUrl: String = "",

        @field:SerializedName("description")
        val description: String = "",

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("poster")
        val poster: String = "",
        @field:SerializedName("year")
        val year: Int = 0,
        @field:SerializedName("genre")
        val genre: String = "",

        @field:SerializedName("imdb")
        val imdb: String = "",

        @field:SerializedName("duration")
        val duration: String = ""
)
