package com.example.noteappyt.features.core.presentation

import android.content.Context
import android.widget.Toast


fun toastMsg(
    context: Context,
    msg:String
)= Toast.makeText(
    context,
    msg,
    Toast.LENGTH_SHORT
).show()