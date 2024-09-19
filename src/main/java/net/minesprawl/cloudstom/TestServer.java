package net.minesprawl.cloudstom;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandSender;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.block.Block;
import org.incendo.cloud.SenderMapper;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.jetbrains.annotations.NotNull;

public class TestServer {
    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();

        InstanceManager instanceManager = MinecraftServer.getInstanceManager();
        InstanceContainer instanceContainer = instanceManager.createInstanceContainer();

        instanceContainer.setGenerator(unit -> unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));

        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(instanceContainer);
            player.setRespawnPoint(new Pos(0, 42, 0));
        });

        MinestomCommandManager<CommandSender> commandManager = new MinestomCommandManager(
                ExecutionCoordinator.asyncCoordinator(),
                new SenderMapper<CommandSender, CommandSender>() {
                    @NotNull
                    @Override
                    public CommandSender map(@NotNull CommandSender base) {
                        return base;
                    }

                    @NotNull
                    @Override
                    public CommandSender reverse(@NotNull CommandSender mapped) {
                        return mapped;
                    }
                }
        );

        minecraftServer.start("0.0.0.0", 25565);
    }
}
