package net.minesprawl.cloudstom;

import net.minestom.server.MinecraftServer;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.cloud.Command;
import org.incendo.cloud.component.CommandComponent;
import org.incendo.cloud.context.CommandContext;
import org.incendo.cloud.internal.CommandRegistrationHandler;

import java.util.Collection;

public class MinestomRegistrationHandler<C> implements CommandRegistrationHandler<C> {
    private MinestomCommandManager<C> commandManager;

    MinestomRegistrationHandler<C> initialize(MinestomCommandManager<C> commandManager) {
        this.commandManager = commandManager;
        return this;
    }

    @Override
    public boolean registerCommand(@NonNull Command<C> cloudCommand) {
        CommandComponent<C> component = cloudCommand.rootComponent();
        String name = component.name();
        Collection<String> aliases = component.alternativeAliases();

        net.minestom.server.command.builder.Command command = new net.minestom.server.command.builder.Command(
                name,
                aliases.toArray(new String[0])
        );

        this.commandManager.commandTree().getNamedNode(command.getName()).children().forEach(child -> {
        });

        command.setDefaultExecutor((sender, context) -> cloudCommand.commandExecutionHandler().execute(new CommandContext<>(commandManager.senderMapper().map(sender), commandManager)));

        MinecraftServer.getCommandManager().register(command);
        return true;
    }
}
