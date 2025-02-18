package prueba_bomberman;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class BombermanView extends JPanel implements Observer {
    private BombermanModel model;

    public BombermanView(BombermanModel model) {
        this.model = model;
        model.addObserver(this);
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 50;
        Player player = model.getPlayer();
        List<Bomb> bombs = model.getBombs();

        // Dibujar mapa
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

        // Dibujar jugador
        g.setColor(Color.BLUE);
        g.fillOval(player.getX() * cellSize + 10, player.getY() * cellSize + 10, 30, 30);

        // Dibujar bombas
        g.setColor(Color.RED);
        for (Bomb bomb : bombs) {
            g.fillOval(bomb.getX() * cellSize + 15, bomb.getY() * cellSize + 15, 20, 20);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
