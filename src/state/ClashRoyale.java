package state;

import arena.Arena;
import core.Timer;
import entity.Entity;
import entity.Troops;
import entity.spell.Log;
import entity.tower.KingTower;
import entity.tower.PrincessTower;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.ArrayList;

public class ClashRoyale {
    private RenderWindow window;
    private int window_width = 1280;
    private int window_height = 720;
    private Vector2f mousepos;
    public Arena arena = new Arena();
    private Troops current_troops = null;
    private boolean CanDrop = false;
    private boolean mousePressed = false;
    public ArrayList<Entity> entities = new ArrayList<>();
    private RectangleShape rectangleShape = new RectangleShape(new Vector2f(100,100));

    public static float dt;
    public ClashRoyale()
    {
        window = new RenderWindow(new VideoMode(window_width,window_height), "ClashRoyale");
        Timer.clock.restart();
        rectangleShape.setPosition(550, 400);
        window.setFramerateLimit(30);
        initTowers();
    }
    public void run()
    {
        while(window.isOpen())
        {
            update();
            render();
        }
    }
    private void update()
    {
        mousepos = this.window.mapPixelToCoords(Mouse.getPosition(window));
        pullEvent();
            for(Entity e : entities)
            {
                e.tick();
            }
        checkForCollision();
        if(rectangleShape.getGlobalBounds().contains(mousepos))
        {
            if(Mouse.isButtonPressed(Mouse.Button.LEFT))
            {
                current_troops = Troops.LOG;
                mousePressed = true;
            }
        }
        if(!Mouse.isButtonPressed(Mouse.Button.LEFT) && mousePressed)
        {
            CanDrop = true;
            mousePressed = false;
        }
        PlaceCard();

        entities.removeIf(Entity::isDead);

    }
    private void pullEvent()
    {
        for(Event event : window.pollEvents())
        {
            switch (event.type)
            {
                case CLOSED:
                    window.close();
                    break;
            }
        }
    }
    private void render()
    {
        window.clear();
        arena.render(window);
        for(Entity e : entities)
        {
            e.render(window);
        }
        window.draw(rectangleShape);
        window.display();
    }

    public Vector2f getMousepos() {
        return mousepos;
    }
    private void PlaceCard()
    {
        if(current_troops!=null && Mouse.isButtonPressed(Mouse.Button.LEFT) && CanDrop)
        {
            switch(current_troops)
            {
                case LOG:
                    Log log = new Log();
                    log.setPosition(mousepos.x, mousepos.y);
                    entities.add(log);
                    current_troops = null;
                    CanDrop = false;
                    break;
            }
        }
    }
    private void UpdateDt()
    {
        dt = Timer.clock.getElapsedTime().asSeconds();
    }

    private void initTowers()
    {
        KingTower redTower = new KingTower(KingTower.RedPosition);
        entities.add(redTower);
        PrincessTower princessTower1 = new PrincessTower(PrincessTower.RedPrincessTower1Pos);
        entities.add(princessTower1);
        PrincessTower princessTower2 = new PrincessTower(PrincessTower.RedPrincessTower2Pos);
        entities.add(princessTower2);

    }
    private void checkForCollision()
    {
        for(int i=0;i< entities.size();i++)
        {
            for(Entity e : entities)
            {
                if(e != entities.get(i) && e.getSprite().getGlobalBounds().contains(entities.get(i).getSprite().getPosition()))
                {
                    System.out.println("Collisione");
                }
            }
        }
    }
}
