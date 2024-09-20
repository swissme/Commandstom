package net.minesprawl.commandstom;

import com.google.common.collect.Maps;
import lombok.Getter;
import net.minesprawl.commandstom.parameters.StringParameterAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class CommandstomHandler {

    private final Map<Class<?>, ParameterAdapter<?>> parameterAdapters = Maps.newConcurrentMap();

    public CommandstomHandler() {
        this.registerParameterAdapter(String.class, new StringParameterAdapter());
    }

    /**
     * Register multiple commands using object instances.
     */
    public void registerCommands(Object... objects) {
        for (Object object : objects) {
            registerCommand(object);
        }
    }

    /**
     * Register a command using an object instance.
     */
    public void registerCommand(Object... objects) {

    }

    /**
     * Register a ParameterAdapter
     *
     * @param clazz   The class for the adapter
     * @param adapter The adapter
     * @param <T>     Type
     */

    public <T> void registerParameterAdapter(@NotNull Class<T> clazz, @NotNull ParameterAdapter<T> adapter) {
        parameterAdapters.putIfAbsent(clazz, adapter);
    }

}
