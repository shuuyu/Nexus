package live.shuuyu.nexus.commands.application

import dev.kord.core.entity.Guild
import dev.kord.core.entity.User
import dev.kord.core.entity.channel.Channel

open class ApplicationCommandContext (
        sender: User,
        guild: Guild,
        channel: Channel,
)