package prueba_bomberman;

class Player {
    private int x, y;
    private boolean vivo;

    public Player(int x, int y) { this.x = x; this.y = y; this.vivo = true; }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

class Bomb {
    private int x, y, timer;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = 3;
    }

    public void tick() { timer--; }

    public int getTimer() { return timer; }
    public int getX() { return x; }
    public int getY() { return y; }
}
