package net.minesprawl.commandstom.parameters;

import net.kyori.adventure.text.format.TextColor;
import net.minesprawl.commandstom.ParameterAdapter;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BooleanTypeAdapter implements ParameterAdapter<Boolean> {

    @Override
    public Boolean process(@NotNull String str) {
        String lowered = str.toLowerCase();
        if (lowered.equals("yes")) {
            return true;
        } else if (lowered.equals("no")) {
            return false;
        }

        return lowered.equals("true");
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(TextColor.fromHexString("#ff0000") + "'" + given + "' is not a valid boolean.");
    }

}
