package live.shuuyu.test.commands

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.nexus.commands.SlashCommand
import live.shuuyu.nexus.commands.application.ApplicationCommandArguments

class TestCommand : SlashCommand(
    name = "test",
    description = "A very simple test command.",
    permissions = Permissions(Permission.BanMembers, Permission.KickMembers),
    dmPermissions = false
) {
    inner class options : ApplicationCommandArguments() {

    }

    override suspend fun execute() {
        TODO("Not yet implemented")
    }
}