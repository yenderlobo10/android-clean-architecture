package co.mergedev.marvelcharacters.common.resources

import android.util.Log
import timber.log.Timber

/**
 * Implement timber tree to release variant.
 */
class TimberReleaseTree() : Timber.Tree() {

    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {

        if (priority == Log.ERROR) {
            TODO("Send crashlytics report")
        }
    }
}