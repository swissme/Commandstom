package net.minesprawl.commandstom.parameters;

import net.minesprawl.commandstom.ParameterAdapter;
import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StringParameterAdapter implements ParameterAdapter<String> {

    @Override
    public @Nullable String process(@NotNull String input) {
        return input;
    }

    @Override
    public void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception) {
        // this never happens bc the input can always because translated to a string
    }

}
