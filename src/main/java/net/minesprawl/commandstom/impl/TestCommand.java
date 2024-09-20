package net.minesprawl.commandstom.impl;

import net.minesprawl.commandstom.Commandstom;

public class TestCommand extends Commandstom {

    public TestCommand() {
        super("test", "t");

        setDefaultExecutor((sender, context) -> {
            sender.sendMessage("Hello, world!");
        });

        addSyntax((sender, context) -> {
            sender.sendMessage("Hello, world!");
        });
    }

}
