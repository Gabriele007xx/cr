package arena;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
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
        if(Mouse.isButtonPressed(Mouse.Button.LEFT) && ClashRoyale.isDrop)
        {
            ClashRoyale.clicked_tile_x = col;
            ClashRoyale.clicked_tile_y = row;
        }
    }
}
