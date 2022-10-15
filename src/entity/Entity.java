package entity;

import core.MoveComponent;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Shape;

public abstract class Entity {
    protected MoveComponent moveComponent;
    public void tick()
    {

    }
    public abstract void render(RenderTarget target);
    public void setPosition(float x, float y)
    {

    }
    public abstract Shape getSprite();
}
