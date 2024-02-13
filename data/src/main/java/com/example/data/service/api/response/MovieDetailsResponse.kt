package com.example.data.service.api.response

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("belongs_to_collection") val belongsToCollection: String?,
    @SerializedName("budget") val budget: Int,
    @SerializedName("genres") val genreIds: List<MovieDetailsGenreResponse>,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdbId: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("production_companies") val productionCompanies: List<MovieProductionCompaniesResponse>,
    @SerializedName("production_countries") val productionCountries: List<MovieProductionCountriesResponse>,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("revenue") val revenue: Int,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("spoken_languages") val spokenLanguages: List<MovieSpokenLanguagesResponse>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int
)

data class MovieDetailsGenreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class MovieProductionCompaniesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
)

data class MovieProductionCountriesResponse(
    @SerializedName("iso_3166_1") val iso31661: Int,
    @SerializedName("name") val name: Int
)

data class MovieSpokenLanguagesResponse(
    @SerializedName("english_name") val englishName: Int,
    @SerializedName("iso_639_1") val iso6391: Int,
    @SerializedName("name") val name: Int
)
