package core;

import entity.Entity;
import org.jsfml.system.Vector2f;

public class MoveComponent {
    private Vec2 velocity = new Vec2(0,0);
    float maxspeed;
    float acc;

    float dacc;
    Entity entity;
    public MoveComponent(float maxspeed,float acc,float dacc, Entity entity)
    {
        this.maxspeed = maxspeed;
        this.acc = acc;
        this.entity = entity;
    }
    public void update(float dt)
    {
        if(velocity.x > 0f)
        {
            if (velocity.x > maxspeed)
            {
                velocity.x = maxspeed;
            }
            velocity.x -= dacc;
            if(velocity.x < 0)
            {
                velocity.x = 0f;
            }
        }
        else if(velocity.x < 0f)
        {
            if(velocity.x < -maxspeed)
            {
                velocity.x = -maxspeed;
            }
            velocity.x += dacc;
            if(velocity.x > 0f)
            {
                velocity.x = 0f;
            }
        }
        if(velocity.y > 0f)
        {
            if (velocity.y > maxspeed)
            {
                velocity.y = maxspeed;
            }
            velocity.y -= dacc;
            if(velocity.y < 0)
            {
                velocity.y = 0f;
            }
        }
        else if(velocity.y < 0f)
        {
            if(velocity.y < -maxspeed)
            {
                velocity.y = -maxspeed;
            }
            velocity.y += dacc;
            if(velocity.y > 0f)
            {
                velocity.y = 0f;
            }
        }
        entity.getSprite().move(velocity.toVector2f());

    }
    public void move(float x, float y, float dt)
    {
        velocity.x += acc * x;
        velocity.y += acc*y;
    }
}
