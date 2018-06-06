//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.embedded

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomAttributesContentBuilder
import o.org.katydom.builders.KatyDomEmbeddedContentBuilder
import o.org.katydom.types.ECorsSetting
import o.org.katydom.types.EDirection
import o.org.katydom.types.EReferrerPolicy

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<img>` element.
 */
internal class KatyDomImg<Msg>(
    embeddedContent: KatyDomEmbeddedContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    alt: String,
    contenteditable: Boolean?,
    crossorigin: ECorsSetting?,
    dir: EDirection?,
    height: Int?,
    hidden: Boolean?,
    ismap: Boolean?,
    lang: String?,
    referrerpolicy: EReferrerPolicy?,
    sizes: String?,
    spellcheck: Boolean?,
    src: String,
    srcset: String?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    usemap: String?,
    width: Int?,
    defineAttributes: KatyDomAttributesContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {

        setAttribute("alt", alt)
        setAttribute("crossorigin", crossorigin?.toHtmlString())
        setNumberAttribute("height", height)
        // TODO: ismap requires <a href> ancestor
        setBooleanAttribute("ismap", ismap)
        setAttribute("referrerpolicy", referrerpolicy?.toHtmlString())
        setAttribute("sizes", sizes)
        setAttribute("src", src)
        setAttribute("srcset", srcset)
        setAttribute("usemap", usemap)
        setNumberAttribute("width", width)

        embeddedContent.attributesContent(this).defineAttributes()
        this.freeze()
    }

    ////

    override val nodeName = "IMG"

}

//---------------------------------------------------------------------------------------------------------------------

