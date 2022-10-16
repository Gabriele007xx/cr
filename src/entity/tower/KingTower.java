package entity.tower;

import arena.Tile;
import core.Vec2;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Shape;

public class KingTower extends AbstractTower{
    public static final Vec2 RedPosition = new Vec2(9* Tile.TILE_SIZE, 3 * Tile.TILE_SIZE);
    public KingTower(Vec2 position)
    {
        radius = 1.4f * Tile.TILE_SIZE;
        shape = new CircleShape(this.radius);
        HitSpeed = 1.0f;
        shape.setOrigin(shape.getRadius() / 2, shape.getRadius() / 2);
        shape.setPosition(position.toVector2f());
        shape.setFillColor(Color.YELLOW);

    }

    @Override
    public void tick() {
        super.tick();

    }

    @Override
    public Shape getSprite() {
        return shape;
    }
}
