package net.minesprawl.commandstom.parameters;

import net.kyori.adventure.text.format.TextColor;
import net.minesprawl.commandstom.ParameterAdapter;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerTypeAdapter implements ParameterAdapter<Player> {

    @Override
    public Player process(@NotNull String str) {
        return MinecraftServer.getConnectionManager().getOnlinePlayerByUsername(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(TextColor.fromHexString("#ff0000") + "'" + given + "' is not online.");
    }

}
