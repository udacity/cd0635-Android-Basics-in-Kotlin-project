package com.udacity.pawhaven.data

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.udacity.pawhaven.R

sealed class AnimalType(
    val label: String,
    @DrawableRes val defaultIconRes: Int,
    @RawRes val defaultSoundRes: Int
) {
    data object DogType : AnimalType("Dog", R.drawable.ic_dog, R.raw.dog_bark)
    // Add more sealed class animals


    init {
        register(this)
    }

    fun defaultDescription(name: String): String =
        "$name is a cheerful ${label.lowercase()}."


    fun createAnimal(
        id: String,
        name: String,
        age: Int,
        description: String = DogType.defaultDescription(name),
        @DrawableRes imageRes: Int = DogType.defaultIconRes,
        @RawRes soundRes: Int = DogType.defaultSoundRes
    ) : Animal {
        return when (this) {
            DogType -> Dog(id, name, age, description, imageRes, soundRes)
           //TODO add more sealed classes

        }
    }


    companion object {
        private val registry = mutableListOf<AnimalType>()

        private fun register(type: AnimalType) {
            registry.add(type)
        }


        /** Public, read-only list */
        val all: List<AnimalType>
            get() = registry.toList()
    }

}