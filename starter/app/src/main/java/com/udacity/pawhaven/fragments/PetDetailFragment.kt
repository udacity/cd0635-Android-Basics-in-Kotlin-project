package com.udacity.pawhaven.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.udacity.pawhaven.R
import com.udacity.pawhaven.components.PlayPauseComponent
import com.udacity.pawhaven.data.Animal

class PetDetailFragment : Fragment(R.layout.fragment_pet_detail) {

    lateinit var petImage: ImageView
    lateinit var petName: TextView
    lateinit var petAge: TextView
    lateinit var description: TextView
    lateinit var soundButton: PlayPauseComponent

    lateinit var shareButton: MaterialButton
    lateinit var adoptButton: MaterialButton

    // The current pet being shown
    private var currentPet: Animal? = null


    var onAdopt: ((Animal) -> Unit)? = { animal ->
        Toast.makeText(
            requireContext(),
            getString(R.string.adoption_coming_soon),
            Toast.LENGTH_LONG
            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        petImage = view.findViewById(R.id.detailPetImage)
        petName = view.findViewById(R.id.detailPetName)
        petAge = view.findViewById(R.id.detailPetAge)
        description = view.findViewById(R.id.detailDescription)
        soundButton = view.findViewById(R.id.detailSoundButton)
        shareButton = view.findViewById(R.id.detailShareButton)


        adoptButton = view.findViewById(R.id.adoptButton)

        adoptButton.setOnClickListener {
            currentPet?.let { onAdopt?.invoke(it) }
        }

        // 👇 Render now that views exist
        renderIfReady()
    }

    private fun sharePet(pet: Animal) {
        val shareText = buildShareText(pet)

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
            putExtra(Intent.EXTRA_TEXT, shareText)
        }

        startActivity(Intent.createChooser(intent, getString(R.string.share)))
    }

    private fun buildShareText(pet: Animal): String {
        // Keep it simple + friendly (and localizable later if you want)
        return "Adopt a ${pet.type.label}: ${pet.name} 🐾\n" +
                "${pet.description}\n" +
                "Age: ${pet.age} years\n" +
                "Shared from PawHaven"
    }



    fun bind(pet: Animal) {
        currentPet = pet
        renderIfReady()
    }

    fun renderIfReady() {
        val pet = currentPet ?: return
        if (!isAdded || view == null) return
        petImage.setImageResource(pet.imageRes)
        soundButton.setSound(pet.soundRes)
        petName.text = pet.name
        petAge.text = getString(R.string.age_years_format, pet.age)
        description.text = pet.description
        shareButton.setOnClickListener {
            sharePet(pet)
        }
    }
}