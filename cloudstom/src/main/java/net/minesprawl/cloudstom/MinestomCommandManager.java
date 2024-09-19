package net.minesprawl.cloudstom;

import net.minestom.server.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.cloud.CommandManager;
import org.incendo.cloud.SenderMapper;
import org.incendo.cloud.SenderMapperHolder;
import org.incendo.cloud.execution.ExecutionCoordinator;

public class MinestomCommandManager<C> extends CommandManager<C> implements SenderMapperHolder<CommandSender, C> {
    private final SenderMapper<CommandSender, C> senderMapper;

    protected MinestomCommandManager(
            final @NonNull ExecutionCoordinator<C> executionCoordinator,
            final @NonNull SenderMapper<CommandSender, C> senderMapper
    ) {
        super(executionCoordinator, new MinestomRegistrationHandler<>());
        this.senderMapper = senderMapper;
    }

    @Override
    public boolean hasPermission(@NonNull C sender, @NonNull String permission) {
        if (permission.isEmpty()) {
            return true;
        }
        return senderMapper.reverse(sender).hasPermission(permission);
    }

    @Override
    public @NonNull SenderMapper<CommandSender, C> senderMapper() {
        return senderMapper;
    }
}
