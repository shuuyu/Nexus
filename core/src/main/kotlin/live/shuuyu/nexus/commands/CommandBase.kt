package live.shuuyu.nexus.commands

/**
 * Makes the given command
 */
@Target(AnnotationTarget.CLASS)
annotation class EphemeralSlashCommand(
    val name: String,
    val description: String
)

@Target(AnnotationTarget.CLASS)
annotation class PublicSlashCommand(
    val name: String,
    val description: String
)

@Target(AnnotationTarget.CLASS)
annotation class MessageCommand(
    val name: String,
    val description: String
)

@Target(AnnotationTarget.FUNCTION)
annotation class SubCommand(
    val name: String,
    val description: String
)