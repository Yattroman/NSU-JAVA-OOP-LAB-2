package ru.nsu.yattroman;

import org.junit.jupiter.api.Test;
import ru.nsu.yattroman.command.Command;
import ru.nsu.yattroman.command.CommandHandler;

import static org.junit.jupiter.api.Assertions.*;

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

        String[] commandAndArgs2 = {"INIT", "10", "10", "10", "0"};
        Exception exception2 = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs2, ch.getArgsCheckers(), gm) );

        assertEquals("-> Init command arguments are invalid. Rewrite arguments.", exception2.getMessage());

        String[] commandAndArgs3 = {"INIT", "110", "-1", "0", "0"};
        Exception exception3 = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs3, ch.getArgsCheckers(), gm) );

        assertEquals("-> Init command arguments are invalid. Rewrite arguments.", exception3.getMessage());
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

        String[] commandAndArgs2 = {"TELEPORT", "9", "9"};
        currentCommand.execute(commandAndArgs2, ch.getArgsCheckers(), gm);

        assertEquals(9, gm.getMap().getRobot().getCoordinates().getY());
        assertEquals(9, gm.getMap().getRobot().getCoordinates().getX());
    }

    @Test
    void WardCommandTest() {
        String[] commandAndArgs = {"WARD"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Map hasn't been initialized yet.", exception.getMessage());

        initMap();

        currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm);
        assertFalse(gm.getMap().getRobot().getPainterState());
    }

    @Test
    void DrawCommandTest() {
        String[] commandAndArgs = {"DRAW"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Map hasn't been initialized yet.", exception.getMessage());

        initMap();

        currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm);
        assertTrue(gm.getMap().getRobot().getPainterState());

    }

    @Test
    void MoveCommandTest() {
        initMap();
        String[] commandAndArgs = {"MOVE", "O", "1000"};
        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs[0]);

        Exception exception = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs, ch.getArgsCheckers(), gm) );

        assertEquals("-> Move command arguments are invalid. Rewrite arguments.", exception.getMessage());

        String[] commandAndArgs2 = {"MOVE", "D", "5"};
        currentCommand.execute(commandAndArgs2, ch.getArgsCheckers(), gm);
        assertEquals(5, gm.getMap().getRobot().getCoordinates().getY());

        String[] commandAndArgs3 = {"MOVE", "U", "6"};
        currentCommand.execute(commandAndArgs3, ch.getArgsCheckers(), gm);
        assertEquals(9, gm.getMap().getRobot().getCoordinates().getY());

        String[] commandAndArgs4 = {"MOVE", "R", "7"};
        currentCommand.execute(commandAndArgs4, ch.getArgsCheckers(), gm);
        assertEquals(7, gm.getMap().getRobot().getCoordinates().getX());

        String[] commandAndArgs5 = {"MOVE", "L", "8"};
        currentCommand.execute(commandAndArgs5, ch.getArgsCheckers(), gm);
        assertEquals(9, gm.getMap().getRobot().getCoordinates().getX());

        String[] commandAndArgs6 = {"MOVE", "U", "-1000"};

        Exception exception2 = assertThrows(RuntimeException.class,
                () -> currentCommand.execute(commandAndArgs6, ch.getArgsCheckers(), gm) );

        assertEquals("-> Move command arguments are invalid. Rewrite arguments.", exception2.getMessage());
    }

    @Test
    void drawAndWardCoworkTest() {
        initMap();

        assertFalse(gm.getMap().getRobot().getPainterState());

        String[] commandAndArgs1 = {"DRAW"};
        String[] commandAndArgs2 = {"WARD"};

        Command currentCommand = ch.getCommandFactory().getInstance(commandAndArgs1[0]);
        Command nextCommand = ch.getCommandFactory().getInstance(commandAndArgs2[0]);

        currentCommand.execute(commandAndArgs1, ch.getArgsCheckers(), gm);

        assertTrue(gm.getMap().getRobot().getPainterState());

        nextCommand.execute(commandAndArgs1, ch.getArgsCheckers(), gm);

        assertFalse(gm.getMap().getRobot().getPainterState());
    }
}
