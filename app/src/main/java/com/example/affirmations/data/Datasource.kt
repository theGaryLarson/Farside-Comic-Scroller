/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.data


import com.example.affirmations.R
import com.example.affirmations.model.Comic

/**
 * [Datasource] generates a list of [Comic]
 */
class Datasource() {
    fun loadCaptions(): List<Comic> {
        return listOf<Comic>(
            Comic(R.string.caption1, R.drawable.img1),
            Comic(R.string.caption2, R.drawable.img2),
            Comic(R.string.caption3, R.drawable.img3),
            Comic(R.string.caption4, R.drawable.img4),
            Comic(R.string.caption5, R.drawable.img5),
            Comic(R.string.caption6, R.drawable.img6),
            Comic(R.string.caption7, R.drawable.img7),
            Comic(R.string.caption8, R.drawable.img8),
            Comic(R.string.caption9, R.drawable.img9),
            Comic(R.string.caption10, R.drawable.img10),
            Comic(R.string.caption11, R.drawable.img11),
            Comic(R.string.caption12, R.drawable.img12))
    }
}
