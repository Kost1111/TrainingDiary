package com.example.trainingdiary.data

import android.os.Parcel
import android.os.Parcelable

data class BodyParcelable(
    val neck: String?,
    val back: String,
    val belly: String?,
    val breasts: String?,
    val waist: String?,
    val forearmRight: String?,
    val forearmLeft: String?,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(neck)
        parcel.writeString(back)
        parcel.writeString(belly)
        parcel.writeString(breasts)
        parcel.writeString(waist)
        parcel.writeString(forearmRight)
        parcel.writeString(forearmLeft)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BodyParcelable> {
        override fun createFromParcel(parcel: Parcel): BodyParcelable {
            return BodyParcelable(parcel)
        }

        override fun newArray(size: Int): Array<BodyParcelable?> {
            return arrayOfNulls(size)
        }
    }
}
