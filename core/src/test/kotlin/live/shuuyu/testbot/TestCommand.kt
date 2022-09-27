package live.shuuyu.testbot

import dev.kord.core.entity.Guild
import live.shuuyu.nexus.commands.SlashCommand
import live.shuuyu.nexus.commands.application.ApplicationCommandContext
import live.shuuyu.nexus.commands.application.ApplicationCommandOptions
import live.shuuyu.nexus.commands.slash.AbstractSlashCommand

@SlashCommand("test", "A very basic test command!")
class TestCommand: AbstractSlashCommand() {
    inner class options : ApplicationCommandOptions() {

    }
    override suspend fun execute(context: ApplicationCommandContext, guild: Guild) {

    }
}

