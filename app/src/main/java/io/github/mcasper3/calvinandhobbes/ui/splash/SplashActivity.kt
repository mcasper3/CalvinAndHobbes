package io.github.mcasper3.calvinandhobbes.ui.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import io.github.mcasper3.calvinandhobbes.ui.comic.ComicActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = ComicActivity.createIntent(this)
        startActivity(intent)
    }
}
