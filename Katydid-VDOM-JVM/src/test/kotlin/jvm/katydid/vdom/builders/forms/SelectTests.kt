//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.vdom.builders.forms

import jvm.katydid.vdom.api.checkBuild
import o.katydid.vdom.application.katydid
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("RemoveRedundantBackticks")
class SelectTests {

    @Test
    fun `A select element with various options produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            select(
                "#combo",
                autocomplete = "selectable",
                autofocus = true,
                disabled = true,
                form = "myform",
                multiple = true,
                name = "selectit",
                required = true,
                size = 50,
                value = "Two"
            ) {

                option(key = 1) { text("One") }
                option(key = 2) { text("Two") }
                option(key = 3) { text("Three") }

            }

        }

        val html = """<select autocomplete="selectable" autofocus="" disabled="" form="myform" id="combo" multiple="" name="selectit" required="" size="50" value="Two">
                     |  <option>
                     |    One
                     |  </option>
                     |  <option>
                     |    Two
                     |  </option>
                     |  <option>
                     |    Three
                     |  </option>
                     |</select>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A select element's size must be greater than zero`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                select(size = 0) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                select(size = -1) {}
            }

        }

    }

}
