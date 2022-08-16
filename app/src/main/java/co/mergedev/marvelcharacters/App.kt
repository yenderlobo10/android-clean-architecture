package co.mergedev.marvelcharacters

import android.app.Application
import co.mergedev.framework.resource.TimberReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
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