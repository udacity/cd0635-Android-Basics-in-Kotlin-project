package com.udacity.pawhaven.data

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

abstract class Animal(
    val id: String,
    val name: String,
    val age: Int,

    val description: String,
    val imageRes: Int,
    val soundRes: Int
) {
    abstract val type: AnimalType
}


class Dog(
    id: String,
    name: String,
    age: Int,
    description: String = AnimalType.DogType.defaultDescription(name),
    @DrawableRes imageRes: Int = AnimalType.DogType.defaultIconRes,
    @RawRes soundRes: Int = AnimalType.DogType.defaultSoundRes
) : Animal(id, name, age, description, imageRes, soundRes) {
    override val type: AnimalType = AnimalType.DogType
}
// TODO add Cat, Lion, Elephant, Parrot, Bird