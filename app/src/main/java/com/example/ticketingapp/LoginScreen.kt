package com.example.ticketingapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    var phoneNumber by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Warna latar belakang
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF025253))
        )

        // Icon menu
        Icon(
            painter = painterResource(id = R.drawable.iconmenu),
            contentDescription = "Menu Icon",
            modifier = Modifier
                .size(60.dp)
                .padding(start = 30.dp)
                .align(Alignment.CenterStart),
            tint = Color.White
        )

        Icon(
            painter = painterResource(id = R.drawable.logoxxi),
            contentDescription = "Logo",
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.Center),
            tint = Color(0xFFCFAB7A)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.logomtix),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .size(230.dp))

        OutlinedTextField(value = phoneNumber, onValueChange = { phoneNumber = it },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.iconhp), contentDescription = "HandphoneIcon", modifier = Modifier.size(20.dp))},
            label = { Text(text = "Handphone") },
            placeholder = { Text(text = "Enter your phone number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password,  onValueChange = { password = it },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.iconlock), contentDescription = "PasswordIcon", modifier = Modifier.size(20.dp))},
            label = { Text(text = "PIN/Password") },
            placeholder = { Text(text = "PIN/Password (6-digit number)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate(Routes.MovieScreen)
                Log.i("Credential", "Phone Number : $phoneNumber Password : $password")
            },
            modifier = Modifier
                .width(280.dp)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF025253))
        ) {
            Text(
                text = "Log In",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Or")

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { Log.i("Credential", "Phone Number : $phoneNumber Password : $password") },
            modifier = Modifier
                .width(280.dp)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBE985A))
        ) {
            Text(
                text = "Register m.tix",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Forgot Password?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 53.dp)
                .clickable { },
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
            textAlign = androidx.compose.ui.text.style.TextAlign.End
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Once you have received OTP Activation code\nthrough SMS,",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF7B7B7B),
            textAlign = androidx.compose.ui.text.style.TextAlign.Start // Mengatur teks menjadi rata kiri
        )

        Spacer(modifier = Modifier.height(2.dp))

        // Teks "Please activate your m.tix here"
        Text(
            text = "Please activate your m.tix here",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFD08A4C),
            modifier = Modifier
                .padding(end = 80.dp)
        )
    }
}