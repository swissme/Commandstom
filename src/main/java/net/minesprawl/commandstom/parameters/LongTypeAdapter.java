package net.minesprawl.commandstom.parameters;


import net.mineworks.prisons.prisonscore.utils.command.adapters.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class LongTypeAdapter implements ParameterAdapter<Long> {

    @Override
    public Long process(@NotNull String str) {
        return Long.valueOf(str);
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        sender.sendMessage(ChatColor.RED + "'" + given + "' is not a valid number.");
    }
}
