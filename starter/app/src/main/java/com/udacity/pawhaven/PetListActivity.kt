package com.udacity.pawhaven

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import com.udacity.pawhaven.PetDetailActivity.Companion.EXTRA_PET_ID
import com.udacity.pawhaven.data.Animal
import com.udacity.pawhaven.fragments.PetDetailFragment
import com.udacity.pawhaven.fragments.PetListFragment

class PetListActivity : BaseActivity(), PetListFragment.Host {

    private val isTwoPane: Boolean by lazy {
        findViewById<View?>(R.id.detailContainer) != null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_list_activity)
    }

    override fun onPetSelected(pet: Animal) {}
    override fun onAddPet() {}
}
