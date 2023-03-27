package com.example.composewithroom.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composewithroom.ui.viewmodel.ContactEvent
import com.example.composewithroom.ui.viewmodel.ContactState
import com.example.composewithroom.R
import com.example.composewithroom.data.room.Contact
import com.example.composewithroom.ui.theme.ComposeWithRoomTheme


@Composable
fun ContactScreen(state: ContactState, event: (ContactEvent) -> Unit, modifier: Modifier = Modifier) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            event(ContactEvent.ShowDialog)
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(id = R.string.add_contact))
        }
    }) { padding ->
        if (state.isAddingContact) {
            AddContactDialog(event = event, state = state)
        }
        LazyColumn(contentPadding = padding, modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(state.contacts.size) {
                ContactItemRow(contact = state.contacts[it], onDeleteContact = {
                    event(ContactEvent.DeleteContact(it))
                })
            }
        }
    }

}

@Composable
fun ContactItemRow(modifier: Modifier = Modifier, contact: Contact,onDeleteContact:(Contact)->Unit) {
    Card() {
        Row(modifier = modifier.padding(vertical = 10.dp, horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, modifier = Modifier
                .size(60.dp)
                .clip(RectangleShape))
            Column(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)) {
                Text(text = contact.firstName.plus(" ").plus(contact.lastName), style = TextStyle(fontSize = MaterialTheme.typography.body2.fontSize))
                Text(text = contact.phoneNumber, style = TextStyle(fontSize = MaterialTheme.typography.body2.fontSize))
            }
            Icon(Icons.Rounded.Delete, "", modifier = Modifier
                .padding(horizontal = 10.dp)
                .clickable {onDeleteContact.invoke(contact)})
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ContactScreenPrev() {
    ComposeWithRoomTheme {
        //ContactScreen()
    }
}