package com.example.composewithroom.ui.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.composewithroom.data.ContactRepository
import com.example.composewithroom.data.room.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ContactViewModel(private val contactRepository: ContactRepository) : ViewModel() {


    private val _state = MutableStateFlow(ContactState())

    val state: MutableStateFlow<ContactState>
        get() = _state


    init {
        viewModelScope.launch {
            contactRepository.getContactOrderByFirstName().collect { contact ->
                _state.update { it.copy(contacts = contact) }
            }
        }
    }


    fun contactEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    contactRepository.deleteContact(event.contact)
                }
            }

            ContactEvent.SaveContact -> {
                val contact =
                    Contact(firstName = state.value.firstName, lastName = state.value.lastName, phoneNumber = state.value.phoneNumber)
                viewModelScope.launch {
                    contactRepository.insertContact(contact)
                }
                _state.update {
                    it.copy(firstName = "", lastName = "", phoneNumber = "", isAddingContact = false)
                }
            }
            is ContactEvent.SetFirstName -> {
                _state.update { it.copy(firstName = event.firstName) }
            }
            is ContactEvent.SetLastName -> {
                _state.update {
                    it.copy(lastName = event.lastName)
                }
            }
            is ContactEvent.SetPhoneNumber -> {
                _state.update { it.copy(phoneNumber = event.phoneNumber) }
            }
            ContactEvent.ShowDialog -> {
                _state.update { it.copy(isAddingContact = true) }
            }
            ContactEvent.HideDialog -> {
                _state.update { it.copy(isAddingContact = false) }
            }
        }
    }

}

class ContactViewModelFactory(private val repository: ContactRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return ContactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}