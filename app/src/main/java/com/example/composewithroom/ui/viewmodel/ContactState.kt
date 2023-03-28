package com.example.composewithroom.ui.viewmodel

import com.example.composewithroom.data.room.Contact

data class ContactState(
    val firstName:String="",
    val lastName:String="",
    val phoneNumber:String="",
    val contacts:List<Contact> = emptyList(),
    val isAddingContact: Boolean=false,
)
