package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Comic] is the data class to represent the Affirmation text and imageResourceId
 */
data class Comic(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)