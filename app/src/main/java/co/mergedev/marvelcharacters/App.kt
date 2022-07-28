package co.mergedev.marvelcharacters

import android.app.Application
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }


    private fun setupTimber() {

        Timber.plant(Timber.DebugTree())
    }
}