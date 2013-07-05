package com.jakecoffman;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    @Before
    public void setUp() {
        //
    }

    @After
    public void tearDown() {
        //
    }

    @Test
    public void testUnderPopulation() {
        ArrayList<List<Integer>> exp = new ArrayList<List<Integer>>(3);
        exp.add(Arrays.asList(0, 0, 0));
        exp.add(Arrays.asList(0, 0, 0));
        exp.add(Arrays.asList(0, 0, 0));
        Game expected = new Game(exp, 3);

        ArrayList<List<Integer>> initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(0, 1, 0));
        initial.add(Arrays.asList(0, 1, 0));
        initial.add(Arrays.asList(0, 0, 0));
        Game game = new Game(initial, 3);
        game.tick();
        assertEquals(expected.print(), game.print());

        initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(0, 0, 0));
        initial.add(Arrays.asList(0, 1, 0));
        initial.add(Arrays.asList(0, 0, 1));
        game = new Game(initial, 3);
        game.tick();

        assertEquals(expected.print(), game.print());
        initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(1, 0, 1));
        initial.add(Arrays.asList(0, 0, 0));
        initial.add(Arrays.asList(1, 0, 1));
        game = new Game(initial, 3);
        game.tick();
        assertEquals(expected.print(), game.print());
    }

    @Test
    public void testLiveOn() {
        ArrayList<List<Integer>> initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(1, 1, 0));
        initial.add(Arrays.asList(1, 1, 0));
        initial.add(Arrays.asList(0, 0, 0));
        Game expected = new Game(initial, 3);

        Game game = new Game(initial, 3);
        game.tick();
        assertEquals(expected.print(), game.print());

        initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(0, 1, 0));
        initial.add(Arrays.asList(1, 1, 0));
        initial.add(Arrays.asList(0, 0, 0));
        game = new Game(initial, 3);

        game.tick();
        assertEquals(expected.print(), game.print());
    }

    @Test
    public void testReproduction() {
        ArrayList<List<Integer>> exp = new ArrayList<List<Integer>>(3);
        exp.add(Arrays.asList(0, 0, 0));
        exp.add(Arrays.asList(1, 1, 0));
        exp.add(Arrays.asList(0, 0, 0));
        Game expected = new Game(exp, 3);

        ArrayList<List<Integer>> initial = new ArrayList<List<Integer>>(3);
        initial.add(Arrays.asList(0, 1, 0));
        initial.add(Arrays.asList(1, 0, 0));
        initial.add(Arrays.asList(0, 1, 0));
        Game game = new Game(initial, 3);
        game.tick();

        assertEquals(expected.print(), game.print());
    }
}
