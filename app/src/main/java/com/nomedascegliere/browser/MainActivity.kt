package com.nomedascegliere.browser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView

class MainActivity : AppCompatActivity() {

    companion object {
        private var runtime: GeckoRuntime? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<GeckoView>(R.id.geckoview)
        val session = GeckoSession()

        if (runtime == null) {
            runtime = GeckoRuntime.create(this)
        }
        session.open(runtime!!)
        view.setSession(session)
        session.loadUri("https://www.google.com")
    }
}