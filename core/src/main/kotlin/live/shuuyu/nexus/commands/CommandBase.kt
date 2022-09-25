package live.shuuyu.nexus.commands

import live.shuuyu.nexus.commands.data.CommandType

/**
 * Sets up the command.
 *
 * @param name The name of the given command.
 * @param description The description of the given command.
 * @param permissions The permissions required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
@Target(AnnotationTarget.CLASS)
annotation class Command(
    val name: String,
    val description: String = "No description was set.",
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