package net.minesprawl.commandstom.annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Commandstom {

    @NotNull String[] labels();

    @NotNull String description() default "N/A";

    boolean async() default false;

}
