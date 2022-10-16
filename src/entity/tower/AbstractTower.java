package entity.tower;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.RenderTarget;

public abstract class AbstractTower {
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
