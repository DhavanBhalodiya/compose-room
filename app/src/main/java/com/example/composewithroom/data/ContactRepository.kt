package com.example.composewithroom.data

import com.example.composewithroom.data.room.Contact
import com.example.composewithroom.data.room.ContactDao
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val dao: ContactDao) {

    suspend fun deleteContact(contact: Contact) {
        dao.deleteContact(contact)
    }

    suspend fun insertContact(contact: Contact) {
        dao.insertContact(contact)
    }

     fun getContactOrderByFirstName(): Flow<List<Contact>> {
         return dao.getContactOrderByFirstName()
    }

}