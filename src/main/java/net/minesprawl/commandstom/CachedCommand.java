package net.minesprawl.commandstom;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.ToString;
import net.minesprawl.commandstom.annotations.Commandstom;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@ToString
@Getter
public class CachedCommand {

    private final @NotNull String label;
    private final @NotNull List<String> args;

    private final @NotNull String description;
    private final boolean async;
    private final @NotNull Method method;
    private final @NotNull Object object;
    private final boolean playersOnly;

    public CachedCommand(@NotNull String label,
                         @NotNull List<String> args,
                         @NotNull String description,
                         boolean async,
                         @NotNull Method method,
                         @NotNull Object object) {
        this.label = label;
        this.args = args;
        this.description = description;
        this.async = async;
        this.method = method;
        this.object = object;
        this.playersOnly = method.getParameters()[0].getType() == Player.class;
    }

    @NotNull
    public static List<CachedCommand> of(@NotNull Commandstom annotation, @NotNull Method method, @NotNull Object object) {
        final List<CachedCommand> commands = Lists.newArrayList();

        for (String label : annotation.labels()) {
            final String[] split = label.split(CommandstomHandler.CMD_SPLITTER);

            commands.add(new CachedCommand(
                    split[0],
                    Arrays.asList(split).subList(1, split.length),
                    annotation.description(),
                    annotation.async(),
                    method,
                    object)
            );
        }

        return commands;
    }

}
