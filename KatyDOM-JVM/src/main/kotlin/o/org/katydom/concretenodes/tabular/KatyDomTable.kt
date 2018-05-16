//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.concretenodes.tabular

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.builders.KatyDomTableContentBuilder
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a `<table>` element.
 */
internal class KatyDomTable<Msg>(
    flowContent: KatyDomFlowContentBuilder<Msg>,
    selector: String?,
    key: Any?,
    accesskey: String?,
    border: Boolean?,
    contenteditable: Boolean?,
    dir: EDirection?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatyDomTableContentBuilder<Msg>.() -> Unit
) : KatyDomHtmlElement<Msg>(selector, key, accesskey, contenteditable, dir,
                            hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        flowContent.contentRestrictions.confirmTableAllowed()

        if (border != null) {
            setAttribute("border", if (border) "1" else "")
        }

        flowContent.tableContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "TABLE"

}

//---------------------------------------------------------------------------------------------------------------------