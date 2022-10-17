package arena;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import state.ClashRoyale;

public class Tile {
    public static int TILE_SIZE = 16;
    public int col;
    public int row;
    public int gCost;
    public int hCost;
    public boolean start;
    public boolean goal;
    public TileType type;
    public boolean checked;

    private RectangleShape shape = new RectangleShape();
    public Tile()
    {

    }
    public Tile(int col, int row)
    {
        this.col = col;
        this.row = row;
    }
    public RectangleShape getShape() {
        return shape;
    }
    public void render(RenderTarget target)
    {
        target.draw(shape);
    }
    public void setAsGoal()
    {
        this.goal = true;
    }

    public void setStart() {
        this.start = true;
    }
    public void tick()
    {
        if(Mouse.isButtonPressed(Mouse.Button.LEFT) && ClashRoyale.isDrop && shape.getGlobalBounds().contains(ClashRoyale.mousepos))
        {
           // ClashRoyale.clicked_tile_x = col;
          //  ClashRoyale.clicked_tile_y = row;
        }
    }
    public Vector2f getCenter()
    {
        return new Vector2f(shape.getPosition().x + TILE_SIZE / 2f, shape.getPosition().y + TILE_SIZE / 2f);
    }
}
