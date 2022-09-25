package live.shuuyu.testbot

import dev.kord.core.entity.Guild
import live.shuuyu.nexus.commands.SlashCommand
import live.shuuyu.nexus.commands.application.ApplicationCommandContext
import live.shuuyu.nexus.commands.slash.AbstractSlashCommand

@SlashCommand("test", "A very basic test command!")
class TestCommand: AbstractSlashCommand() {
    override suspend fun execute(context: ApplicationCommandContext, guild: Guild) {

    }
}