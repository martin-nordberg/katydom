//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.elements

//---------------------------------------------------------------------------------------------------------------------

/**
 * Abstract Katydid class corresponding to a DOM HTMLElement node. Accepts the global attributes available
 * to most HTML tags.
 * @param Msg the type of message returned by events from this element when an Elm-like architecture is in use.
 */
@Suppress("unused")
interface KatydidHtmlElement<Msg> : KatydidElement<Msg>

//---------------------------------------------------------------------------------------------------------------------

