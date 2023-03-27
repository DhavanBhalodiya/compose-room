package com.example.composewithroom.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1,exportSchema = false)
abstract class ContactDataBase: RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDatabase(context: Context): ContactDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDataBase::class.java,
                    "contact_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}