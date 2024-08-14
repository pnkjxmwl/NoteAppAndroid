package com.example.noteappyt.features.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.noteappyt.features.core.ui.theme.ubuntuFontFamily


@Composable
fun EmptyListScreen(){
    Box(modifier=Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Empty List!", fontFamily = ubuntuFontFamily, fontSize = 22.sp)
    }
}