package net.minesprawl.commandstom;

import net.minestom.server.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ParameterAdapter<T> {

    /**
     * Called when it tries to get an object for a param
     *
     * @param input The input you receive like "hey"
     * @return T
     */
    @Nullable
    T process(@NotNull String input);

    /**
     * Called when there is an error like phrasing error.
     *
     * @param sender    - Command Sender
     * @param given     - The input from process
     * @param exception - The error provided.
     */
    void processException(@NotNull CommandSender sender, @NotNull String given, @NotNull Exception exception);

}
