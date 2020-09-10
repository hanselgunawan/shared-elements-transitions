package com.hanseltritama.sharedelementstransitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.view.View
import android.view.Window
import androidx.appcompat.widget.ActionBarContainer

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val fade = Fade()
        val decor: View = window.decorView
        val resId = resources.getIdentifier("action_bar_container", "id", "android")

        // Removing the flash white screen between transitions
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O_MR1) {
            fade.excludeTarget(decor.findViewById<ActionBarContainer>(resId), true)
        } else {
            fade.excludeTarget(decor.findViewById(resId) as ActionBarContainer?, true)
        }
        fade.excludeTarget(android.R.id.statusBarBackground, true)
        fade.excludeTarget(android.R.id.navigationBarBackground, true)
        window.enterTransition = Explode()
        window.exitTransition = Explode()
    }
}
