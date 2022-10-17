package entity;

import arena.Tile;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Shape;
import state.ClashRoyale;
import util.DamageSource;

public abstract class Troop extends Entity{
    protected CircleShape shape;
    protected Tile startTile;

    @Override
    public void render(RenderTarget target) {

    }

    @Override
    public void tick() {
        super.tick();
        this.findTarget();
        this.walk();
    }

    @Override
    public Shape getSprite() {
        return shape;
    }

    @Override
    public DamageSource attack() {
        return null;
    }

    @Override
    public void onSpawn() {

    }
    public void setSpawn()
    {
        startTile.col = ClashRoyale.clicked_tile_x;
        startTile.row = ClashRoyale.clicked_tile_y;
    }
    protected void walk()
    {

    }
    protected void findTarget()
    {

    }
}
