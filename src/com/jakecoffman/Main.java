package com.jakecoffman;

public class Main {

    public static void main(String[] args) {
	    Game game = new Game(8);
        System.out.println(game.print());
        for(int i=0; i<5; i++){
            System.out.println(game.print());
            game.tick();
        }
    }
}
