package entity.spell;

import arena.Tile;
import core.MoveComponent;
import entity.Entity;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Shape;
import org.jsfml.system.Vector2f;
import state.ClashRoyale;

public class Log extends Entity {
    private static final  float LOG_WIDTH = 3.9f;
    private static final float LOG_HEIGHT = 1.2f;
    private RectangleShape shape = new RectangleShape(new Vector2f(LOG_WIDTH*Tile.TILE_SIZE,LOG_HEIGHT*Tile.TILE_SIZE));
    public Log()
    {
        shape.setOrigin(LOG_WIDTH/2f,LOG_HEIGHT/2f);
        shape.setFillColor(Color.BLUE);
        moveComponent = new MoveComponent(1f,0.1f,0.3f,this);
    }
    @Override
    public void tick() {
        super.tick();
        moveComponent.update(ClashRoyale.dt);
        travel();
    }
    private void travel()
    {
        moveComponent.move(0, -(10*Tile.TILE_SIZE), ClashRoyale.dt);
    }

    @Override
    public void render(RenderTarget target) {
        target.draw(shape);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x,y);
        shape.setPosition(x,y);
    }

    @Override
    public Shape getSprite() {
        return shape;
    }
}
