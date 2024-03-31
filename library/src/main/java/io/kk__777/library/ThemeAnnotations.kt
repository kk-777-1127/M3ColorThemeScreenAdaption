package io.kk__777.library

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class StaticColorSourceTheme(
    val color: Long, // TODO Support Int or ULong?
    val fullyQualifiedTheme: String
)

//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.SOURCE)
//annotation class StaticUriSourceTheme(
//    val uri: String,
//    val fullyQualifiedTheme: String
//)