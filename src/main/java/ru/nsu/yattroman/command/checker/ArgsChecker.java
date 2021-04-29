package ru.nsu.yattroman.command.checker;

/**
 * Абстрактный класс ArgsChecker - "проверяльщик аргументов", родительский для специализированных "проверяльщиков аргументов"
 */
public abstract class ArgsChecker {
    public abstract boolean check(String... args);
}
