package entity.tower;

import entity.Entity;
import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.RenderTarget;

public abstract class AbstractTower extends Entity {
    protected CircleShape shape;
    protected float radius;
    protected float HitSpeed;


    public AbstractTower()
    {

    }
    public void render(RenderTarget target)
    {
        target.draw(shape);
    }
    public void tick()
    {

    }



}
