package co.mergedev.domain.model

import co.mergedev.domain.model.resource.ResourceList
import co.mergedev.domain.model.resource.ResourceSummary
import java.util.*

/**
 * Represent a marvel character.
 */
interface ICharacter {

    val id: Long
    val name: String
    val description: String?
    val modified: Date?
    val resourceURI: String
    val urls: List<IUrl>?
    val thumbnail: IImage?
    val comics: Any?
    val stories: Any?
    val events: Any?
    val series: Any?

    val alias: String
    val nameWithoutAlias: String
}