package live.shuuyu.nexus.commands.user

import dev.kord.core.entity.Member
import dev.kord.core.entity.User
import live.shuuyu.nexus.commands.application.ApplicationCommandContext

abstract class AbstractSlashCommand {
    abstract suspend fun execute(context: ApplicationCommandContext, user: User, member: Member)
}