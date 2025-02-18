package prueba_bomberman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

class BombermanController {
    private BombermanModel model;

    public BombermanController(BombermanModel model, BombermanView view) {
        this.model = model;

        // Crear ventana
        JFrame frame = new JFrame("Bomberman MVC + Observer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Agregar KeyListener para manejar teclas
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        });

        // Loop de actualización cada segundo
        new Timer(1000, e -> model.update()).start();
    }

    private void handleKeyPress(int keyCode) {
        Player player = model.getPlayer();
        int x = player.getX();
        int y = player.getY();

        switch (keyCode) {
            case KeyEvent.VK_W: y = Math.max(0, y - 1); break;
            case KeyEvent.VK_S: y = Math.min(9, y + 1); break;
            case KeyEvent.VK_A: x = Math.max(0, x - 1); break;
            case KeyEvent.VK_D: x = Math.min(9, x + 1); break;
            case KeyEvent.VK_SPACE: model.placeBomb(); return;
        }

        model.movePlayer(x, y);
    }
}
