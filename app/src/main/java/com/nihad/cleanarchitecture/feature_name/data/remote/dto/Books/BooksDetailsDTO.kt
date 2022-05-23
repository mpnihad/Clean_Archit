package com.nihad.cleanarchitecture.feature_name.data.remote.dto.Books

import com.nihad.cleanarchitecture.feature_name.domain.model.Books

data class BooksDetailsDTO(
    val code: Int,
    val `data`: List<Data>,
    val status: String,
    val total: Int
)

fun BooksDetailsDTO.toBooks(): List<Books> {

    return data.map {
        Books(
            author = it.author,
            description = it.description,
            id = it.id,
            image = it.image,
            published = it.published,
            publisher = it.publisher,
            title = it.title

        )
    }
}