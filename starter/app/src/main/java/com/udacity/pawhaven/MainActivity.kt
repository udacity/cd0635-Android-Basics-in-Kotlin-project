package com.udacity.pawhaven

import android.os.Bundle
import com.google.android.material.button.MaterialButton

/**
 * Main entry point of the app.
 *
 * TODO (Student Task):
 * - When the "Get Started" button is clicked,
 *   navigate to ProfileActivity.
 */


class MainActivity : BaseActivity() {

    lateinit var getStartedButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO:
        // Use findViewById to get button with "getStarted" id

        // Set up button click behavior
        setUpGetStartedButton()
    }

    private fun setUpGetStartedButton() {

        getStartedButton.setOnClickListener {
            // TODO:
            // 1. Create an Intent to open ProfileActivity
            // 2. Start the Activity
        }
    }
}
