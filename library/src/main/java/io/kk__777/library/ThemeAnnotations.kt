package io.kk__777.library

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class StaticColorSourceTheme(
    val name: String,
    val rgbColor: Long, // TODO Support Int or ULong?
)

//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.SOURCE)
//annotation class StaticUriSourceTheme(
//    val uri: String,
//)