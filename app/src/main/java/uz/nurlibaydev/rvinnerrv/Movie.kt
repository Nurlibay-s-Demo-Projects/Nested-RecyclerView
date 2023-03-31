package uz.nurlibaydev.rvinnerrv

import java.io.Serializable

/**
 *  Created by Nurlibay Koshkinbaev on 25/03/2023 22:49
 */

data class Movie(
    val title: String,
    val img: String = "",
): Serializable