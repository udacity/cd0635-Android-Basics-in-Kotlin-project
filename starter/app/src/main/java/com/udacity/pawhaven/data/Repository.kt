package com.udacity.pawhaven.data

internal object Repository {

    val validVolunteers = setOf(
        newVolunteer("Grace", "Johnson", 28),
        newVolunteer("Samuel", "Okoye", 35),
        newVolunteer("Amina", "Diallo", 30),
        newVolunteer("Marie", "Dupont", 26)
    )


    // Replace later with your real model/persistence
   val pets = listOf(
        Dog("1", "Bella", 2),
       // TODO Uncomment on these animals once these classes are added.
//        Cat("2", "Max", 3),
//        Elephant("3", "Charlie", 5),
//        Bird("4", "Cindy", 4),
//        Lion("5", "Darrel", 4),
//        Parrot("6", "Parry", 1),
        )

    fun getPetById(id: String): Animal? {
        return pets.find { it.id == id }
    }
}