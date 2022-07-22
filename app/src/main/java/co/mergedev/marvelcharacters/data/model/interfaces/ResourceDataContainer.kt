package co.mergedev.marvelcharacters.data.model.interfaces

/**
 * Represent result-data model of api body response wrapper.
 *
 * @param offset The requested offset (number of skipped results) of the call.
 * @param limit The requested result limit.
 * @param total The total number of resources available given the current filter set.
 * @param count The total number of results returned by this call.
 * @param results The list of items returned by the call.
 */
interface ResourceDataContainer<T> {

    val offset: Int
    val limit: Int
    val total: Int
    val count: Int
    val results: List<T>
}