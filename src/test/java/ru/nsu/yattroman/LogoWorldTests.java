package ru.nsu.yattroman;

import org.junit.jupiter.api.Test;
import ru.nsu.yattroman.command.Command;
import ru.nsu.yattroman.command.CommandHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogoWorldTests {

    private final GameMaster gm = new GameMaster();
    private final CommandHandler ch = gm.getCommandHandler();

    @Test
    void initCommandTest() {
        String[] commandAndArgs = {"INIT", "10", "10", "-1", "-1"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Init command arguments are invalid. Rewrite arguments.", exception.getMessage());
    }

    void initMap(){
        String[] commandAndArgs = {"INIT", "10", "10", "0", "0"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);
        currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm);
    }

    @Test
    void TeleportCommandTest() {
        initMap();
        String[] commandAndArgs = {"TELEPORT", "-1", "-1"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Teleport command arguments are invalid. Rewrite arguments.", exception.getMessage());
    }

    @Test
    void WardCommandTest() {
        String[] commandAndArgs = {"WARD"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Map hasn't been initialized yet.", exception.getMessage());
    }

    @Test
    void DrawCommandTest() {
        String[] commandAndArgs = {"DRAW"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Map hasn't been initialized yet.", exception.getMessage());
    }

    @Test
    void MoveCommandTest() {
        initMap();
        String[] commandAndArgs = {"MOVE", "O", "1000"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Move command arguments are invalid. Rewrite arguments.", exception.getMessage());
    }

}
