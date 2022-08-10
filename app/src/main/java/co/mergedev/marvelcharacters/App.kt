package co.mergedev.marvelcharacters

import android.app.Application
import co.mergedev.framework.resource.TimberReleaseTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }


    private fun setupTimber() {

        Timber.plant(
            if (BuildConfig.DEBUG) Timber.DebugTree()
            else TimberReleaseTree()
        )
    }
}