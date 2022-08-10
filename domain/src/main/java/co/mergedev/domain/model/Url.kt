package co.mergedev.domain.model

import co.mergedev.domain.model.IUrl

/**
 * URLs are references to web pages or deep links into applications.
 *
 * @param type A text identifier for the URL.
 * @param url A full URL (including scheme, domain, and path).
 */
data class Url(

    override val type: String?,
    override val url: String?
) : IUrl
