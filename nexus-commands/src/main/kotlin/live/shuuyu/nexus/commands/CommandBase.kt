/*
 * This file is part of Nexus, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Myosyn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package live.shuuyu.nexus.commands

import dev.kord.common.entity.Permissions
import live.shuuyu.nexus.commands.application.ApplicationCommandContext

/**
 * Sets up a  slash command. This is only executable via using /.
 *
 * @param name The name of the given command.
 * @param description The description of the given command.
 * @param permissions The permissions required to execute the given command.
 * @param dmPermissions Allows/Disallows direct messages to be sent with the command.
 *
 * @since 0.0.1
 * @author yujin
 */
abstract class SlashCommand(
    val name: String,
    val description: String? = "No description provided",
    val permissions: Permissions?,
    val dmPermissions: Boolean? = false
) {
    abstract suspend fun execute(context: ApplicationCommandContext)
}

/**
 * Sets up a user command.
 *
 * @param name The name of the command.
 * @param permissions The permissions required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
abstract class UserCommand(
    val name: String,
    val permissions: Permissions?,
    val dmPermissions: Boolean? = false
) {

}

/**
 * Sets up a message command. You require the setup of a prefix in order to use this.
 *
 * @param name The name of the command.
 * @param permissions The permission required to execute the given command.
 *
 * @since 0.0.1
 * @author yujin
 */
abstract class MessageCommand(
    val name: String,
    val permissions: Permissions?,
    val dmPermissions: Boolean?
) {

}

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
    val permissions: LongArray = [],
    val dmPermissions: Boolean = false
)