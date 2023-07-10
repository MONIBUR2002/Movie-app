package com.moniapps.movieapp.ViewsF

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.moniapps.movieapp.Models.Movies
import com.moniapps.movieapp.R
import com.moniapps.movieapp.ui.theme.Orange

@Composable
fun MoiveItem(movies: Movies) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxSize()
            .height(150.dp), shape = RoundedCornerShape(8.dp), elevation = 8.dp
    ) {
        Surface {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = movies.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            scale(Scale.FILL)
                            placeholder(R.drawable.corrupt_file)
                            transformations(RoundedCornersTransformation())
                            size(300, 400)
                        }).build()
                ), contentDescription = movies.desc,

                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movies.name,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)

                    )
                    Text(text = movies.category, style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(color = Orange)
                            .padding(4.dp))

                    Text(text = movies.desc, fontSize = 14.sp,
                        maxLines = 5, overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}
