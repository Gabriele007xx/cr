package entity;

import core.MoveComponent;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Shape;
import util.DamageSource;

public abstract class Entity {
    protected int damage;
    protected int health;
    protected int maxhealth;
    protected boolean dead = false;
    protected boolean LogHurted = false;
    protected MoveComponent moveComponent;
    public void tick()
    {

    }
    public abstract void render(RenderTarget target);
    public void setPosition(float x, float y)
    {

    }
    public abstract Shape getSprite();

    public boolean isDead() {
        return dead;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }
    public boolean hurt(int damage, DamageSource source)
    {
        if(source == DamageSource.LOG)
        {
            if(LogHurted)
            {
                return false;
            }
            LogHurted = true;

        }
        scaleHealth(damage);
        return true;
    }
    public void setLogHurted(boolean logHurted) {
        LogHurted = logHurted;
    }

    public boolean isLogHurted() {
        return LogHurted;
    }
    public abstract DamageSource attack();
    protected void scaleHealth(int damage)
    {
        health -= damage;
        if(health <= 0)
        {
            dead = true;
        }
    }

}
