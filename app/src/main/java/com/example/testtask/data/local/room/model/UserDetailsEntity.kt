package com.example.testtask.data.local.room.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtask.data.local.room.constants.RoomConstants


@Entity(tableName = RoomConstants.USER_DETAILS_TABLE_NAME)
data class UserDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val gender: String,
    @Embedded
    val name: NameEntity,
    @Embedded
    val location: LocationEntity,
    val email: String,
    @Embedded
    val login: LoginEntity,
    @Embedded
    val dob: DateOfBirthEntity,
    val phone: String,
    @Embedded
    val picture: PictureEntity,
    val nat: String
)



