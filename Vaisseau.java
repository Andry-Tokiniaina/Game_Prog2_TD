package org.example;

public class Vaisseau {
    public int x;
    public int y;
    public Direction direction;

    public enum Direction {
        U, D, R, L
    }

    public Vaisseau() {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.D;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case U -> this.y--;
            case D -> this.y++;
            case R -> this.x++;
            case L -> this.x--;
        }
    }
}
