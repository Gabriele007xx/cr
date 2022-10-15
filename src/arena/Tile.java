package arena;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;

public class Tile {
    public static int TILE_SIZE = 16;
    private RectangleShape shape = new RectangleShape();

    public RectangleShape getShape() {
        return shape;
    }
    public void render(RenderTarget target)
    {
        target.draw(shape);
    }
}
