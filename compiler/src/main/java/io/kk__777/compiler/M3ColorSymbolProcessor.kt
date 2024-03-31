package io.kk__777.compiler

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration

class M3ColorSymbolProcessor(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator,
): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        // TODO KSFunctionDeclarationにComposableのアノテーションがついているかを検証する
        resolver.getSymbolsWithAnnotation("io.kk__777.library.StaticColorSourceTheme")
            .filterIsInstance<KSFunctionDeclaration>()
            .forEach {
                logger.info("messagemessagemessagemessagemessagemessagemessagemessagemessage")
            }
        logger.info("11 messagemessagemessagemessagemessagemessagemessagemessagemessage")
        println("hogejigkodnsfvads")

        return emptyList()
    }
}

