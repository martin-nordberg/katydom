//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

//---------------------------------------------------------------------------------------------------------------------

/** Enumeration of background positions. */
@Suppress("EnumEntryName")
enum class EBackgroundPosition(
    private val css: String
) {

    /** The "bottom" background position option. */
    bottom("bottom"),

    /** The "center" background position option. */
    center("center"),

    /** The "left" background position option. */
    left("left"),

    /** The "right" background position option. */
    right("right"),

    /** The "top" background position option. */
    top("top");

    /** @return the CSS attribute text for this background position option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null     -> null
                "bottom" -> bottom
                "center" -> center
                "left"   -> left
                "right"  -> right
                "top"    -> top
                else     -> throw IllegalArgumentException("Unknown display option: '$option'.")
            }

    }

}

//---------------------------------------------------------------------------------------------------------------------


