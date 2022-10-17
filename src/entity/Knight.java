package entity;

import arena.Tile;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Shape;
import util.DamageSource;

public class Knight extends Troop{

    public Knight()
    {
        shape.setRadius(0.25f* Tile.TILE_SIZE);
    }
    @Override
    public void render(RenderTarget target) {
        target.draw(shape);
    }

    @Override
    public Shape getSprite() {
        return shape;
    }

    @Override
    public DamageSource attack() {
        return DamageSource.MELEE;
    }

    @Override
    public boolean hurt(int damage, DamageSource source) {
        return true;
    }

    @Override
    public void onSpawn() {
    super.onSpawn();
    }
}
