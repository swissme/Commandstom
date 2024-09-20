package net.minesprawl.commandstom.impl;

import net.minesprawl.commandstom.annotations.Commandstom;
import net.minesprawl.commandstom.annotations.parameter.Param;
import net.minestom.server.entity.Player;

public class TeleportCommand {

    @Commandstom(labels = {"teleport", "tp"}, description = "Teleport to a player.", async = false)
    public void onTeleportCommand(Player player,
                                  @Param("target") Player target) {
        player.teleport(target.getPosition());
    }

}
