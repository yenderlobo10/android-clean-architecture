package co.mergedev.marvelcharacters.data.model.interfaces

/**
 * Represent a resource list of summary items.
 *
 * @param available The number of total available items in this list.
 * @param returned The number of items returned in this collection (up to 20).
 * @param collectionURI The path to the full list of items in this collection.
 * @param items The list of returned items in this collection.
 */
interface ResourceList<T> {

    val available: Int
    val returned: Int
    val collectionURI: String
    val items: List<T>
}
