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
class MeterTests {

    @Test
    fun `A meter element with floating point attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                meter(
                    high = 90.0,
                    low = 10.0,
                    max = 100.0,
                    min = 0.0,
                    optimum = 50.0,
                    value = 40.0
                ) {}

            }

        }

        val html = """<form>
                     |  <meter high="90.0" low="10.0" max="100.0" min="0.0" optimum="50.0" value="40.0"></meter>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A meter element with integer attributes produces correct HTML`() {

        val vdomNode = katydid<Unit> {

            form {

                meter(
                    high = 90,
                    low = 10,
                    max = 100,
                    min = 0,
                    optimum = 50,
                    value = 40
                ) {}

            }

        }

        val html = """<form>
                     |  <meter high="90" low="10" max="100" min="0" optimum="50" value="40"></meter>
                     |</form>""".trimMargin()

        checkBuild(html, vdomNode)

    }

    @Test
    fun `A meter may not be nested`() {

        assertThrows<IllegalStateException> {

            katydid<Unit> {

                meter(value = 0.5) {
                    meter(value = 0.2) {}
                }

            }

        }

    }

    @Test
    fun `A meter's range must be well-defined`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(value = 5, min = 10, max = 0) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(value = 0.5, min = 1.0, max = 0.0) {}
            }

        }

    }

    @Test
    fun `A meter's attributes must be in its default range`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(value = 1.1) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(high = 1.1, value = 0.5) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(low = -0.1, value = 0.5) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(optimum = 1.1, value = 0.5) {}
            }

        }

    }

    @Test
    fun `A meter's attributes must be in range`() {

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(min = 0, max = 100, value = 110) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(min = 0, max = 100, high = 110, value = 50) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(min = 0, max = 100, low = -10, value = 50) {}
            }

        }

        assertThrows<IllegalArgumentException> {

            katydid<Unit> {
                meter(min = 0, max = 100, optimum = 110, value = 50) {}
            }

        }

    }

}
