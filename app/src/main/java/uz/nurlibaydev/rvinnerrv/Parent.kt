package uz.nurlibaydev.rvinnerrv

import java.io.Serializable

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 22:56
 */


data class Parent(
    val title: String,
    val movies: List<Movie>
): Serializable