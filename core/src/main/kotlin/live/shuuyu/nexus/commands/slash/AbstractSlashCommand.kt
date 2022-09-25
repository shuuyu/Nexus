package live.shuuyu.nexus.commands.slash

import dev.kord.core.entity.Guild
import live.shuuyu.nexus.commands.application.ApplicationCommandContext

abstract class AbstractSlashCommand {
    abstract suspend fun execute(context: ApplicationCommandContext, guild: Guild)
}