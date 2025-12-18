package com.udacity.pawhaven

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)
    }

    companion object {
        const val EXTRA_PET_ID = "extra_pet_id"
    }
}
