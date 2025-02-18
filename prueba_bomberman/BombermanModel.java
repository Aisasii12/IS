package prueba_bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

class BombermanModel extends Observable {
    private int width, height;
    private Player player;
    private List<Bomb> bombs;

    public BombermanModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(1, 1);
        this.bombs = new ArrayList<>();
    }

    public Player getPlayer() { return player; }
    public List<Bomb> getBombs() { return bombs; }

    public void movePlayer(int newX, int newY) {
        player.move(newX, newY);
        setChanged();
        notifyObservers();
    }

    public void placeBomb() {
        bombs.add(new Bomb(player.getX(), player.getY()));
        setChanged();
        notifyObservers();
    }

    public void update() {
        bombs.removeIf(bomb -> {
            bomb.tick();
            return bomb.getTimer() <= 0;
        });

        setChanged();
        notifyObservers();
    }
}
