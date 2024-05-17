package com.example.ticketingapp

import android.widget.GridLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MoviesScreen() {
    val movies = listOf(
        Movie("DO YOU SEE WHAT I SEE", R.drawable.film1),
        Movie("IF: IMAGINARY FRIEND", R.drawable.film2),
        Movie("KINGDOM OF THE PLANET OF THE APES", R.drawable.film3),
        Movie("ABIGAIL", R.drawable.film4)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        LocationBar()
        MovieList(movies)
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFF025253))
    ) {
        Image(
            painter = painterResource(R.drawable.iconmenu),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(start = 30.dp)
                .align(Alignment.CenterStart),
        )
        Image(
            painter = painterResource(R.drawable.logoxxi),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.Center),
        )
    }
}

@Composable
fun LocationBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(Color.White)
            .padding(start = 16.dp, top = 16.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.location),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(150.dp)
        )
    }
}

@Composable
fun MovieList(movies: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(movies) { movie ->
            MovieCard(movie)
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
            .width(180.dp)
            .padding(6.dp),
        shape = RoundedCornerShape(5.dp),
        //elevation = 5.dp // Add elevation
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(movie.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(150.dp)
                    .height(205.dp)
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add space between image and text
            Text(
                text = movie.title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "2D     R13+",
                textAlign = TextAlign.Center,
                color = Color(0xFF305858),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 25.dp)
            )
        }
    }
}


