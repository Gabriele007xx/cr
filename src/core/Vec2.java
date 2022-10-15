package core;

import org.jsfml.system.Vector2f;

public class Vec2 {
    public float x;
    public float y;
    public Vec2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2f toVector2f()
    {
        return new Vector2f(x,y);
    }
}
