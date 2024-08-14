package com.example.noteappyt.features.notes.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.outlined.DeleteSweep
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteappyt.features.core.presentation.MainViewModel
import com.example.noteappyt.features.core.ui.theme.poppinsFontFamily
import com.example.noteappyt.features.notes.domain.model.Note


@Composable
fun NoteCard(
    note: Note,
    onEditNoteClick:(Int)->Unit,
    onUndoDeleteClick:()->Unit,
    viewModel: MainViewModel = hiltViewModel()
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape =  RoundedCornerShape(4.dp)
    ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                if(!note.isBookmarked){
                    Spacer(modifier =  Modifier.size(8.dp))
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.weight(8.5f),
                        text = note.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFontFamily
                    )
                    if(note.isBookmarked){
                        IconButton(
                            modifier = Modifier.weight(1.5f),
                            onClick = {}) {
                                Icon(
                                   imageVector = Icons.Filled.BookmarkAdded,
                                    contentDescription = null
                                )
                        }
                    }
                }
                if(!note.description.isNullOrBlank()){
                    Text(text = note.description,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis)
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top= if(note.description.isNullOrBlank()) 4.dp else 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                    thickness = 0.5.dp
                    )
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    IconButton(onClick = {
                        viewModel.deleteNote((note))
                        onUndoDeleteClick()
                    }) {
                        Icon(modifier = Modifier.size(20.dp),
                            imageVector = Icons.Outlined.DeleteSweep,
                            contentDescription = null)
                    }

                    IconButton(onClick = { onEditNoteClick(note.id) }) {
                        Icon(
                            imageVector = Icons.Default.EditNote,
                            contentDescription = null
                        )
                    }
                }
            }
    }
    
}