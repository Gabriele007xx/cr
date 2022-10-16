package entity.tower;

import arena.Tile;
import core.Vec2;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Shape;
import util.DamageSource;

public class PrincessTower extends AbstractTower{
    public static final Vec2 RedPrincessTower1Pos = new Vec2(3.5f* Tile.TILE_SIZE,6.5f*Tile.TILE_SIZE);
    public static final Vec2 RedPrincessTower2Pos = new Vec2(14.5f*Tile.TILE_SIZE,6.5f*Tile.TILE_SIZE);
    public PrincessTower(Vec2 pos)
    {
        radius = 1.0f * Tile.TILE_SIZE;
        shape = new CircleShape(radius);
        HitSpeed = 0.8f;
        shape.setOrigin(shape.getRadius() / 2, shape.getRadius() / 2);
        shape.setPosition(pos.toVector2f());
        shape.setFillColor(Color.YELLOW);
        health = 3052;
        maxhealth = 3052;
        damage = 109;

    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public Shape getSprite() {
        return shape;
    }

    @Override
    public DamageSource attack() {
        return DamageSource.PROJECTILE;
    }

    @Override
    public String toString() {
        return "Princess Tower";
    }

    @Override
    public boolean hurt(int damage, DamageSource source) {
        this.health -= damage;
        if(health <= 0)
        {
            dead = true;
        }
        return super.hurt(damage, source);

    }
}
