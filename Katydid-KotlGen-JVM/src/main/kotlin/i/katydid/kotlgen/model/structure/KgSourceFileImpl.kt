//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.kotlgen.model.structure

import i.katydid.kotlgen.model.annotations.KgAnnotationsImpl
import o.katydid.kotlgen.model.annotations.KgAnnotated
import o.katydid.kotlgen.model.core.KgCodeElement
import o.katydid.kotlgen.model.core.KgOrigin
import o.katydid.kotlgen.model.core.KgOriginUnspecified
import o.katydid.kotlgen.model.core.names.KgQualifiedName
import o.katydid.kotlgen.model.structure.KgImporting
import o.katydid.kotlgen.model.structure.KgSourceFile
import o.katydid.kotlgen.model.structure.KgTopLevelDeclaring

//---------------------------------------------------------------------------------------------------------------------

internal class KgSourceFileImpl(
    override val packageQualifiedName: KgQualifiedName,
    override var name: String
) : KgSourceFile,
    KgAnnotated by KgAnnotationsImpl(),
    KgTopLevelDeclaring by KgTopLevelDeclarationsImpl(),
    KgImporting by KgImportsImpl() {

    private val myQualifiedName = KgQualifiedName(packageQualifiedName, name, KgOriginUnspecified)

    ////

    override val childElements: Iterable<KgCodeElement>
        get() {
            val result = mutableListOf<KgCodeElement>()
            result.addAll(annotations)
            result.addAll(imports)
            result.addAll(declarations)
            return result
        }

    override var documentation: String? = null

    override var nameOrigin: KgOrigin = KgOriginUnspecified

    override var origin: KgOrigin = KgOriginUnspecified

    override val qualifiedName: KgQualifiedName
        get() = myQualifiedName

}

//---------------------------------------------------------------------------------------------------------------------
