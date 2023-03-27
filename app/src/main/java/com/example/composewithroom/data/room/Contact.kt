package com.example.composewithroom.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(

    @PrimaryKey(autoGenerate = true) val id:Int?=null,
    var firstName:String,
    var lastName:String,
    var phoneNumber:String
)
