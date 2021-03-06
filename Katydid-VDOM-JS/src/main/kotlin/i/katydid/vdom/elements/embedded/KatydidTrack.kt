//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.embedded

import i.katydid.vdom.builders.media.KatydidMediaEmbeddedContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidMediaFlowContentBuilderImpl
import i.katydid.vdom.builders.media.KatydidMediaPhrasingContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.ETrackKind

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<track>` element.
 */
internal class KatydidTrack<Msg>
    : KatydidHtmlElementImpl<Msg> {

    constructor(
        mediaContent: KatydidMediaEmbeddedContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        default: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        kind: ETrackKind?,
        label: String?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        srclang: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        mediaContent.mediaContentRestrictions.confirmTrackAllowed()

        setBooleanAttribute("default", default)
        setAttribute("kind", kind?.toHtmlString())
        setAttribute("label", label)
        setAttribute("src", src)
        setAttribute("srclang", srclang)

        mediaContent.attributesContent(this).defineAttributes()
        this.freeze()

    }

    constructor(
        mediaContent: KatydidMediaFlowContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        default: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        kind: ETrackKind?,
        label: String?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        srclang: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        mediaContent.mediaContentRestrictions.confirmTrackAllowed()

        setBooleanAttribute("default", default)
        setAttribute("kind", kind?.toHtmlString())
        setAttribute("label", label)
        setAttribute("src", src)
        setAttribute("srclang", srclang)

        mediaContent.attributesContent(this).defineAttributes()
        this.freeze()

    }

    constructor(
        mediaContent: KatydidMediaPhrasingContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        default: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        kind: ETrackKind?,
        label: String?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        srclang: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir, draggable,
        hidden, lang, spellcheck, style, tabindex, title, translate) {

        mediaContent.mediaContentRestrictions.confirmTrackAllowed()

        setBooleanAttribute("default", default)
        setAttribute("kind", kind?.toHtmlString())
        setAttribute("label", label)
        setAttribute("src", src)
        setAttribute("srclang", srclang)

        mediaContent.attributesContent(this).defineAttributes()
        this.freeze()

    }

    ////

    override val nodeName = "TRACK"

}

//---------------------------------------------------------------------------------------------------------------------


