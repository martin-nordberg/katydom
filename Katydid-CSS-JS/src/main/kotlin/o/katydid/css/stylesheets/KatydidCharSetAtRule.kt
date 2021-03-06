//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing the @charset declaration at the beginning of a style sheet.
 */
@KatydidStyleBuilderDsl
interface KatydidCharSetAtRule
    : KatydidCssRule {

    /** The (unquoted) character set of the rule. */
    val characterSet: String

}

//---------------------------------------------------------------------------------------------------------------------

