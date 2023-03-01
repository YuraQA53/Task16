package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void whenFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 40);
        Player player2 = new Player(2, "Bill", 50);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenThePlayersAreEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 50);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void whenSecondPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Bill", "John")
        );
    }
    @Test
    public void whenFirstPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("John", "Bill")
        );
    }
    @Test
    public void whenBothPlayersDontExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("John", "Sam")
        );
    }
}