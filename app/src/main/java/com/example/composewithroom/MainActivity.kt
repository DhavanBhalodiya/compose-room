package com.example.composewithroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composewithroom.data.ContactRepository
import com.example.composewithroom.data.room.ContactDataBase
import com.example.composewithroom.ui.screens.ContactScreen
import com.example.composewithroom.ui.theme.ComposeWithRoomTheme
import com.example.composewithroom.ui.viewmodel.ContactState
import com.example.composewithroom.ui.viewmodel.ContactViewModel
import com.example.composewithroom.ui.viewmodel.ContactViewModelFactory

class MainActivity : ComponentActivity() {

    private val database by lazy { ContactDataBase.getDatabase(applicationContext) }
    private val repository by lazy { ContactRepository(database.contactDao()) }

    private val contactViewModel:ContactViewModel by viewModels{
        ContactViewModelFactory(repository = repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithRoomTheme {
                val state by contactViewModel.state.collectAsState()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ContactScreen(state = state,event = contactViewModel::contactEvent,modifier = Modifier.padding(horizontal = 12.dp))
                }
            }
        }
    }

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ContactScreenPrev() {
    ComposeWithRoomTheme {
        ContactScreen(state = ContactState(), event ={})
    }
}
