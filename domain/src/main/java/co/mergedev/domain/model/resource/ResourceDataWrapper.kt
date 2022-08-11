package co.mergedev.domain.model.resource

/**
 * Represent api body response wrapper.
 *
 * @param code The HTTP status code of the returned result.
 * @param status A string description of the call status.
 * @param copyright The copyright notice for the returned result.
 * @param attributionText The attribution notice for this result. Please display either
 * this notice or the contents of the attributionHTML field on all screens which contain
 * data from the Marvel Comics API.
 * @param attributionHTML An HTML representation of the [attributionText].
 * @param data The results returned by the call.
 * @param etag A digest value of the content returned by the call.
 */
interface ResourceDataWrapper<T> {

    val code: Int
    val status: String?
    val copyright: String?
    val attributionText: String?
    val attributionHTML: String?
    val data: ResourceDataContainer<T>
    val etag: String?
}