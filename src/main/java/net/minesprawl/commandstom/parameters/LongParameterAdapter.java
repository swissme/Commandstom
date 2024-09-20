package net.minesprawl.commandstom.parameters;

import net.kyori.adventure.text.format.TextColor;
import net.minesprawl.commandstom.ParameterAdapter;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class LongParameterAdapter implements ParameterAdapter<Long> {

    @Override
    public Long process(@NotNull String str) {
        return Long.valueOf(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(TextColor.fromHexString("#FF0000") + "'" + given + "' is not a valid number.");
    }

}
