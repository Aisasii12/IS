package prueba_bomberman;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BombermanModel model = new BombermanModel(10, 10);
            BombermanView view = new BombermanView(model);
            new BombermanController(model, view);
        });
    }
}
