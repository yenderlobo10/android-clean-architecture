package co.mergedev.domain.model

/**
 * URLs are references to web pages or deep links into applications.
 *
 * @param type A text identifier for the URL.
 * @param url A full URL (including scheme, domain, and path).
 */
interface IUrl {

    val type: String?
    val url: String?
}
