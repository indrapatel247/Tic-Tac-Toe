package com.androidgames.tanyasah.tictactoe;

import java.util.Random;

public class BoardEngine {
    private static final Random =new

    Random();

    private char[] elements;
    private char currentPlayer;
    private boolean gameEnded;

    public BoardEngine() {
        elements = new char[9];
        newGame();
    }

    public boolean isGamegameEnded() {
        return gameEnded;
    }

    public char play(int x, int y) {
        if (!gameEnded && elements[3 * y + x] == ' ') {
            elements[3 * y + x] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getElements(int x, int y) {
        return elements[3 * y + x];
    }

    public void newGame() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = ' ';
        }

        currentPlayer = 'X';
        gameEnded = false;
    }

    public char checkEnd() {
        for (int i = 0; i < 3; i++) {
            if (getElements(i, 0) != ' ' &&
                    getElements(i, 0) == getElements(i, 1) &&
                    getElements(i, 1) == getElements(i, 2)) {
                gameEnded = true;
                return getElements(i, 0);
            }

            if (getElements(0, i) != ' ' &&
                    getElements(0, i) == getElements(1, i) &&
                    getElements(1, i) == getElements(2, i)) {
                gameEnded = true;
                return getElements(0, i);
            }
        }

        if (getElements(0, 0) != ' ' &&
                getElements(0, 0) == getElements(1, 1) &&
                getElements(1, 1) == getElements(2, 2)) {
            gameEnded = true;
            return getElements(0, 0);
        }

        if (getElements(2, 0) != ' ' &&
                getElements(2, 0) == getElements(1, 1) &&
                getElements(1, 1) == getElements(0, 2)) {
            gameEnded = true;
            return getElements(2, 0);
        }

        for (int i = 0; i < 9; i++) {
            if (elements[i] == ' ')
                return ' ';
        }

        return 'T';
    }

    public char computer() {
        if (!gameEnded) {
            int position = -1;

            do {
                position = RANDOM.nextInt(9);
            } while (elements[position] != ' ');

            elements[position] = currentPlayer;
            changePlayer();
        }

        return checkEnd();
    }
}