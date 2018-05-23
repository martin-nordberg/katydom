//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.org.katydom.builders.text

import jvm.org.katydom.api.checkBuild
import o.org.katydom.api.katyDom
import org.junit.jupiter.api.Test
import x.org.katydom.types.KatyDateTime
import java.time.ZoneOffset

@Suppress("RemoveRedundantBackticks")
class TimeTests {

    @Test
    fun `A time element produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            time(datetime = KatyDateTime.of(2018, 5, 24, 12, 10, 3, 0, ZoneOffset.ofHours(-5))) {

            }

        }

        val html = """<time datetime="2018-05-24T12:10:03-05:00"></time>"""

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A time element with text content produces correct HTML`() {

        val vdomNode = katyDom<Unit> {

            time() {
                text("2018-05-24 12:10:03.000-05:00")
            }

        }

        val html = """<time>
                     |  2018-05-24 12:10:03.000-05:00
                     |</time>""".trimMargin()

        checkBuild(html, vdomNode)

    }

}
