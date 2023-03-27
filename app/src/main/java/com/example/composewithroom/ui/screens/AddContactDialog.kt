package com.example.composewithroom.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composewithroom.ui.viewmodel.ContactEvent
import com.example.composewithroom.ui.viewmodel.ContactState
import com.example.composewithroom.R

@Composable
fun AddContactDialog(state: ContactState, event: (ContactEvent) -> Unit, modifier: Modifier = Modifier) {
    AlertDialog(modifier=modifier.fillMaxWidth(),onDismissRequest = { event(ContactEvent.HideDialog) },
        title = { Text(text = stringResource(R.string.add_contact), style = TextStyle(fontSize = MaterialTheme.typography.h5.fontSize, fontWeight = FontWeight.Bold),modifier=Modifier.fillMaxWidth()) },
        text = {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(value = state.firstName, onValueChange = {event(ContactEvent.SetFirstName(
                it
            ))}, placeholder = { Text(text = stringResource(R.string.first_name)) })
            TextField(value = state.lastName, onValueChange = {event(ContactEvent.SetLastName(it))}, placeholder = { Text(text = stringResource(R.string.last_name)) })
            TextField(value = state.phoneNumber, onValueChange = {event(ContactEvent.SetPhoneNumber(it))}, placeholder = { Text(text = stringResource(R.string.phone_number)) })
        }
    }, confirmButton = {
        Button(onClick = { event(ContactEvent.SaveContact) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.save_contact))
        }
    })
}
