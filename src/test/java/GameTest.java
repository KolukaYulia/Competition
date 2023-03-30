import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void TestFirstPlayerWin () {
        Game game = new Game();
        Player rembo = new Player(1, "Рэмбо", 200);
        Player terminator = new Player(2, "Терминатор", 100);

        game.register(rembo);
        game.register(terminator);
        int actual = game.round("Рэмбо", "Терминатор");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestSecondPlayerWin () {
        Game game = new Game();
        Player rembo = new Player(1, "Рэмбо", 200);
        Player terminator = new Player(2, "Терминатор", 100);

        game.register(rembo);
        game.register(terminator);
        int actual = game.round("Терминатор", "Рэмбо");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestNoPlayerWin () {
        Game game = new Game();
        Player rembo = new Player(1, "Рэмбо", 200);
        Player terminator = new Player(2, "Терминатор", 200);

        game.register(rembo);
        game.register(terminator);
        int actual = game.round("Рэмбо", "Терминатор");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void TestFirstPlayerRegistered () {
        Game game = new Game();
        Player rembo = new Player(1, "Рэмбо", 200);
        Player terminator = new Player(2, "Терминатор", 200);

        game.register(rembo);
        game.register(terminator);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джокер", "Терминатор")
        );
    }
    @Test
    public void TestSecondPlayerRegistered () {
        Game game = new Game();
        Player rembo = new Player(1, "Рэмбо", 200);
        Player terminator = new Player(2, "Терминатор", 200);

        game.register(rembo);
        game.register(terminator);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Рэмбо", "Джокер")
        );
    }



}
