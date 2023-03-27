package com.example.composewithroom.ui.viewmodel

import com.example.composewithroom.data.room.Contact

sealed interface ContactEvent{
    data class SetFirstName(val firstName:String): ContactEvent
    data class SetLastName(val lastName:String): ContactEvent
    data class SetPhoneNumber(val phoneNumber:String): ContactEvent
    object SaveContact: ContactEvent
    data class DeleteContact(val contact: Contact): ContactEvent
    object ShowDialog: ContactEvent
    object HideDialog: ContactEvent

}

