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
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.theme.AffirmationsTheme
import com.example.affirmations.model.Comic

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    FarsideComicsApp()
                }
            }
        }
    }
}

@Composable
fun FarsideComicsApp() {
    FarsideComicList(
        comicList = Datasource().loadCaptions(),
    )
}

@Composable
fun ComicCard(comic: Comic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = cardColors(
            contentColorFor(backgroundColor = Color.DarkGray)
        )
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id=comic.imageResourceId),
                contentDescription = stringResource(id=comic.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Text(
                text = LocalContext.current.getString(comic.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,

            )
        }
    }
}

@Composable
fun FarsideComicList(comicList: List<Comic>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(comicList) { caption ->
            ComicCard(
                comic = caption,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ComicCardPreview() {
    ComicCard(Comic(R.string.caption1, R.drawable.img1))
}