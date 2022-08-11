package co.mergedev.domain.model

import com.squareup.moshi.Json
import java.util.*

/**
 * Represent a marvel character.
 *
 * @param id The unique ID of the character resource.
 * @param name The name of the character.
 * @param description A short bio or description of the character.
 * @param modified The date the resource was most recently modified.
 * @param resourceURI The canonical URL identifier for this resource.
 * @param urls A set of public web site URLs for the resource.
 * @param thumbnail The representative image for this character.
 * @param comics A resource list containing comics which feature this character.
 * @param stories A resource list of stories in which this character appears.
 * @param events A resource list of events in which this character appears.
 * @param series A resource list of series in which this character appears.
 */
data class Character(

    val id: Long,
    val name: String,
    val description: String?,
    val modified: Date?,
    val resourceURI: String,
    val urls: List<Url>?,
    val thumbnail: Image?,
    val comics: ComicList?,
    val stories: StoryList?,
    val events: EventList?,
    val series: SeriesList?
) {

    @Json(ignore = true)
    val alias: String
        get() {
            val nameAlias =
                name.substringAfter("(").removeSuffix(")")

            return if (nameAlias != name) nameAlias else ""
        }

    @Json(ignore = true)
    val nameWithoutAlias: String
        get() {

            return name.replaceAfter("(", "")
                .removeSuffix("(")
        }
}
