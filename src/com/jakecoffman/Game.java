package com.jakecoffman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int size;
    private List<List<Integer>> board;

    public Game(int size) {
        this.size = size;
        board = newBoard();
    }

    public Game(List<List<Integer>> initial, int size) {
        board = initial;
        this.size = size;
    }

    public void tick() {
        ArrayList<List<Integer>> newBoard = newBoard();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newBoard.get(i).set(j, result(i, j));
            }
        }
        board = newBoard;
    }

    public String print() {
        return board.toString().replace("[", "\n").replace(",", "").replace("]", "").replace("1", "O").replace("0", ".");
    }

    // P R I V A T E

    private ArrayList<List<Integer>> newBoard() {
        Random rand = new Random();

        ArrayList<List<Integer>> newBoard = new ArrayList<List<Integer>>(size);
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> inner = new ArrayList<Integer>();
            for (int j = 0; j < size; j++) {
                inner.add(rand.nextInt(2));
            }
            newBoard.add(inner);
        }
        return newBoard;
    }

    private Integer result(int i, int j) {
        int sum = 0;
        if (j - 1 >= 0) {
            sum += board.get(i).get(j - 1);
            if (i - 1 >= 0) {
                sum += board.get(i - 1).get(j - 1);
            }
            if (i + 1 < size) {
                sum += board.get(i + 1).get(j - 1);
            }
        }
        if (j + 1 < size) {
            sum += board.get(i).get(j + 1);
            if (i - 1 >= 0) {
                sum += board.get(i - 1).get(j + 1);
            }
            if (i + 1 < size) {
                sum += board.get(i + 1).get(j + 1);
            }
        }
        if (i - 1 >= 0) {
            sum += board.get(i - 1).get(j);
        }
        if (i + 1 < size) {
            sum += board.get(i + 1).get(j);
        }
        return (sum == 3 || (sum == 2 && board.get(i).get(j) == 1)) ? 1 : 0;
    }
}
