//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.kotlgen.codegen

import org.junit.jupiter.api.Test

//---------------------------------------------------------------------------------------------------------------------

class KotlinCodeGeneratorRoundTripTests
    : KotlinRoundTripTests() {

    @Test
    fun `A package header and imports parse and regenerate`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1
                    |import sample.pkg2.*
                    |import sample.pkg3 as three
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    @Test
    fun `A simple enum class parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1
                    |
                    |internal enum class ESample {
                    |    A,
                    |    B;
                    |}
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

    @Test
    fun `A top level property parses and regenerates`() {

        val code = """
                    |
                    |package example.pkg1
                    |
                    |import sample.pkg1
                    |
                    |public val x: SomeType
                    |
                    |""".trimMargin()

        checkParseAndCodeGen(code)

    }

}

//---------------------------------------------------------------------------------------------------------------------

