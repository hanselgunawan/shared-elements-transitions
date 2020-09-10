package com.hanseltritama.sharedelementstransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.widget.ActionBarContainer
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        window.enterTransition = fade
        window.exitTransition = fade

        button_main.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            val optionsCompat = ViewCompat.getTransitionName(image_main)?.let { transitionName ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this,
                    image_main,
                    transitionName
                )
            }
            startActivity(intent, optionsCompat?.toBundle())
        }
    }
}
