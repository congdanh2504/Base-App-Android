package com.congdanh.feature.addnote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.congdanh.domain.model.Note

@Composable
fun AddNoteScreen(onAddNote: (Note) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            label = { Text("Title") },
            onValueChange = {
                title = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = description,
            label = { Text("Description") },
            onValueChange = {
                description = it
            },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5
        )
        Button(onClick = {
            if (title.isNotBlank() && description.isNotBlank()) {
                val note = Note(
                    title = title,
                    description = description,
                    timestamp = System.currentTimeMillis()
                )
                onAddNote(note)
            }
        }) {
            Text("Add Note")
        }
    }
}
