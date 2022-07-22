package co.mergedev.marvelcharacters.common.extensions

import timber.log.Timber
import java.security.MessageDigest

/**
 * TODO: document
 */
fun String.toHashMD5(): String {

    return try {

        val md5 = MessageDigest.getInstance("MD5")
        val stringBytes = this.toByteArray(Charsets.UTF_8)
        val digestValue = md5.digest(stringBytes)

        digestValue.joinToString(separator = "") { byte ->
            "%02x".format(byte)
        }

    } catch (ex: Exception) {

        Timber.e(ex)
        this
    }
}