//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.miscellaneous

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.elements.forms.KatydidOptGroup
import i.katydid.vdom.elements.forms.KatydidSelect
import o.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilder
import o.katydid.vdom.builders.miscellaneous.KatydidSelectContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a `<select>` element.
 *
 * @constructor Constructs a new option content builder.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidSelectContentBuilderImpl<Msg>(
    itsElement: KatydidSelect<Msg>,
    itsContentRestrictions: KatydidContentRestrictions,
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidOptGroupContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidSelectContentBuilder<Msg> {

    override fun optGroup(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        disabled: Boolean?,
        draggable: Boolean?,
        hidden: Boolean?,
        label: String,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidOptGroup(this, selector, key, accesskey, contenteditable, dir, disabled,
                            draggable, hidden, label, lang, name, spellcheck, style,
                            tabindex, title, translate, defineContent)
        )
    }

    /**
     * Creates a new content builder for the given child [element] that has the same restrictions
     * as this builder.
     */
    fun optGroupContent(element: KatydidOptGroup<Msg>): KatydidOptGroupContentBuilderImpl<Msg> {
        return KatydidOptGroupContentBuilderImpl(
            element,
            contentRestrictions,
            dispatchMessages
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

