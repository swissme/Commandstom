package net.minesprawl.commandstom.annotations.parameter;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Param {

    /**
     * What the argument is called in the usage.
     * @return the name of the argument
     */
    @NotNull String value();

}
