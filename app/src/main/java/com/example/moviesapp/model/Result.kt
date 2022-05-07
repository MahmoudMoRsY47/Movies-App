package com.example.moviesapp.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Result(
    @SerializedName("adult")
    val adult: Boolean? = false,
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",

    @SerializedName("budget")
    val budget: Int? = 0,

    val key: String = "result",
    @SerializedName("homepage")
    val homepage: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("imdb_id")
    val imdbId: String? = "",
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("original_title")
    val originalTitle: String?= "",
    @SerializedName("overview")
    val overview: String?= "",
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("poster_path")
    val posterPath: String? = "",

    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("revenue")
    val revenue: Int? = 0,
    @SerializedName("runtime")
    val runtime: Int? = 0,

    @SerializedName("status")
    val status: String? = "",
    @SerializedName("tagline")
    val tagline: String?= "",
    @SerializedName("title")
    val title: String?= "",
    @SerializedName("video")
    val video: Boolean? = false,
    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int? = 0,

    @SerializedName("origin_country")
    val originCountry: String? = ""


) : Parcelable

