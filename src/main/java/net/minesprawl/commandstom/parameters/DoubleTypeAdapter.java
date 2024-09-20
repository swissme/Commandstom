package net.minesprawl.commandstom.parameters;

import net.kyori.adventure.text.format.TextColor;
import net.minesprawl.commandstom.ParameterAdapter;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DoubleTypeAdapter implements ParameterAdapter<Double> {

    @Override
    public Double process(@NotNull String str) {
        return Double.valueOf(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(TextColor.fromHexString("#ff0000") + "'" + given + "' is not a valid number.");
    }

}
