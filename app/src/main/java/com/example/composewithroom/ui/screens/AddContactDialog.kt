package com.example.composewithroom.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composewithroom.ui.viewmodel.ContactEvent
import com.example.composewithroom.ui.viewmodel.ContactState
import com.example.composewithroom.R

@Composable
fun AddContactDialog(state: ContactState, event: (ContactEvent) -> Unit, modifier: Modifier = Modifier) {
    var openDialog by remember { mutableStateOf(false) }

    ShowValidationAlert(openDialog, onDismiss = {
        openDialog = false
    }, onConfirmClick = { openDialog = false })


    AlertDialog(modifier = modifier.fillMaxWidth(), onDismissRequest = {
        event(ContactEvent.HideDialog)
    }, title = { Text(text = stringResource(R.string.add_contact), style = TextStyle(fontSize = MaterialTheme.typography.h5.fontSize, fontWeight = FontWeight.Bold), modifier = Modifier.fillMaxWidth()) }, text = {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            TextField(value = state.firstName, onValueChange = {
                event(ContactEvent.SetFirstName(it))
            }, placeholder = { Text(text = stringResource(R.string.first_name)) }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next), maxLines = 1)
            TextField(value = state.lastName, onValueChange = { event(ContactEvent.SetLastName(it)) }, placeholder = { Text(text = stringResource(R.string.last_name)) }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next), maxLines = 1)
            TextField(value = state.phoneNumber, onValueChange = {
               event(ContactEvent.SetPhoneNumber(it))
            }, placeholder = { Text(text = stringResource(R.string.phone_number)) }, maxLines = 1, /*keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done)*/)
        }
    }, confirmButton = {
        Button(onClick = {
            if (state.firstName.isEmpty() || state.lastName.isEmpty() || state.phoneNumber.isEmpty()) {
                openDialog = true
            } else event(ContactEvent.SaveContact)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.save_contact))
        }
    })
}

@Composable
fun ShowValidationAlert(openDialog: Boolean, onDismiss: () -> Unit, onConfirmClick: () -> Unit) {
    if (openDialog) {
        AlertDialog(onDismissRequest = onDismiss, title = { Text(text = stringResource(id = R.string.app_name)) }, text = { Text(text = stringResource(id = R.string.validation_msg)) }, confirmButton = {
            TextButton(onClick = onConfirmClick) {
                Text(text = stringResource(id = R.string.ok), color = MaterialTheme.colors.primary)
            }
        })
    }
}
