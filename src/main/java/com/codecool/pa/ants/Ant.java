package com.codecool.pa.ants;

import static java.lang.Math.sqrt;

import java.util.Random;

public abstract class Ant {

    protected static int nextId = 1;
    protected int id;
    protected int posX;
    protected int posY;
    protected double distanceToQueen;
    protected Random random;

    public Ant(Colony colony) {
        this.posX = getRandomCoord(colony);
        this.posY = getRandomCoord(colony);
        this.distanceToQueen = calcDistanceToQueen();
    }

    public void say(String someString) {
        System.out.println(someString);
    }

    public void timeStep(Colony colony) {
        step();
        this.distanceToQueen = calcDistanceToQueen();
    }

    abstract protected void step();

    protected double calcDistanceToQueen() {
        return sqrt(posX ^ 2 + posY ^ 2);
    }

    protected int getRandomCoord(Colony colony) {
        return random.nextInt(colony.COLONY_SIZE * 2 +1) - colony.COLONY_SIZE;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public double getDistanceToQueen() {
        return distanceToQueen;
    }
}
