package com.example.composewithroom.data.room

import android.content.LocusId
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert  //it is mix with insert and update
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("select * from contact")
    fun getContactList(): Flow<List<Contact>>

    @Query("Select * from contact ORDER BY firstName ASC")
    fun getContactOrderByFirstName(): Flow<List<Contact>>

    @Query("Select * from contact ORDER BY lastName ASC")
    fun getContactOrderByLastName(): Flow<List<Contact>>

    @Query("Select * from contact ORDER BY phoneNumber ASC")
    fun getContactOrderByPhoneNumber(): Flow<List<Contact>>
}