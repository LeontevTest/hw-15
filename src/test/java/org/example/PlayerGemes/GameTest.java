package org.example.PlayerGemes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

public class GameTest {

    @Test

    public void TestWenSecondPlayerWin() {

        Game game = new Game();
        Player kolya = new Player(123, "Коля", 150);
        Player vasya = new Player(124, "Вася", 100);

        game.register(kolya);
        game.register(vasya);

        int actual = game.round("Вася", "Коля");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void TestWenFirstPlayerWin() {

        Game game = new Game();
        Player kolya = new Player(123, "Коля", 150);
        Player vasya = new Player(124, "Вася", 200);

        game.register(kolya);
        game.register(vasya);

        int actual = game.round("Вася", "Коля");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void TestWenStrengthsEqual() {

        Game game = new Game();
        Player kolya = new Player(123, "Коля", 200);
        Player vasya = new Player(124, "Вася", 200);

        game.register(kolya);
        game.register(vasya);

        int actual = game.round("Вася", "Коля");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void TestWenSecondNotRegister() {

        Game game = new Game();
        Player kolya = new Player(123, "Коля", 200);

        game.register(kolya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Коля", "Женя"));

    }

    @Test

    public void TestWenFirstNotRegister() {

        Game game = new Game();
        Player vasya = new Player(124, "Вася", 200);

        game.register(vasya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Женя", "Вася"));

    }


}
