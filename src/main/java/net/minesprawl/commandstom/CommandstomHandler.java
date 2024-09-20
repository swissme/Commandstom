package net.minesprawl.commandstom;

import com.google.common.collect.Maps;
import lombok.Getter;
import net.minesprawl.commandstom.annotations.Commandstom;
import net.minesprawl.commandstom.parameters.*;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Getter
public class CommandstomHandler {

    public static String CMD_SPLITTER = " ";

    private final Map<Class<?>, ParameterAdapter<?>> parameterAdapters = Maps.newConcurrentMap();

    public CommandstomHandler() {
        this.registerParameterAdapter(String.class, new StringParameterAdapter());
        this.registerParameterAdapter(Integer.class, new IntegerParameterAdapter());
        this.registerParameterAdapter(Double.class, new DoubleParameterAdapter());
        this.registerParameterAdapter(Boolean.class, new BooleanParameterAdapter());
        this.registerParameterAdapter(Player.class, new PlayerParameterAdapter());
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
    public void registerCommand(Object object) {
        for (Method method : object.getClass().getMethods()) {
            if (!method.isAnnotationPresent(Commandstom.class)) continue;

            List<CachedCommand> commands = CachedCommand.of(method.getAnnotation(Commandstom.class), method, object);

            for (CachedCommand command : commands) {
                System.out.println(command);
            }
        }
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
