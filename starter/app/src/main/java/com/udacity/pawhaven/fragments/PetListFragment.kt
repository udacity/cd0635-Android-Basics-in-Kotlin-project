package com.udacity.pawhaven.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.udacity.pawhaven.R
import com.udacity.pawhaven.components.PetRowComponent
import com.udacity.pawhaven.data.Animal
import com.udacity.pawhaven.data.Repository

class PetListFragment : Fragment(R.layout.fragment_pet_list) {

    interface Host {
        fun onPetSelected(pet: Animal)
        fun onAddPet()
    }

    private var host: Host? = null
    private var pets = Repository.pets

    override fun onAttach(context: Context) {
        super.onAttach(context)
        host = context as? Host ?: error("Host Activity must implement PetListFragment.Host")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val container = view.findViewById<LinearLayout>(R.id.petListContainer)
        val addFab = view.findViewById<FloatingActionButton>(R.id.addFab)

        addFab.setOnClickListener {
            // TODO: call host?.onAddPet()
        }

        // TODO:
        // 1) Clear container
        // 2) For each pet in `pets`, create a PetRowComponent
        // 3) Bind the pet to the row
        // 4) Wire click callbacks:
        //    - row tap -> host?.onPetSelected(pet)
        // 5) Add the row to the container
        //
        // Required: use PetRowComponent (do not inflate rows manually).
        container.removeAllViews()

        // Example placeholder so screen isn't "mysteriously blank" during early builds:
        // (You can delete this if you want it truly empty.)
        // container.addView(PetRowComponent(requireContext()))
    }

    override fun onDetach() {
        host = null
        super.onDetach()
    }
}