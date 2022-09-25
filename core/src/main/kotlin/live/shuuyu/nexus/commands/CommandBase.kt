package live.shuuyu.nexus.commands

/**
 * Sets up a slash command. This is only executable via using /.
 *
 * @param name The name of the given command.
 * @param description The description of the given command.
 * @param permissions The permissions required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
@Target(AnnotationTarget.CLASS)
annotation class SlashCommand(
    val name: String,
    val description: String = "No description was set.",
    val permissions: LongArray = []
)

/**
 * Sets up a user command.
 *
 * @param name The name of the command.
 * @param permissions The permissions required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
@Target(AnnotationTarget.CLASS)
annotation class UserCommand(
    val name: String,
    val permissions: LongArray = []
)

/**
 * Sets up a message command. You require the setup of a prefix in order to use this.
 *
 * @param name The name of the command.
 * @param permissions the permission required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
@Target(AnnotationTarget.CLASS)
annotation class MessageCommand(
    val name: String,
    val permissions: LongArray = []
)

/**
 * Sets up a sub-command.
 *
 * @param name The name of the given sub-command.
 * @param description The description of the given sub-command.
 * @param permissions The permissions required to execute the given sub-command.
 *
 * @since 0.0.1
 * @author yujin
 */
@Target(AnnotationTarget.FUNCTION)
annotation class SubCommand(
    val name: String,
    val description: String,
    val permissions: LongArray = []
)