package state;

import arena.Arena;
import arena.Tile;
import core.Timer;
import entity.Entity;
import entity.Knight;
import entity.Troops;
import entity.spell.Log;
import entity.tower.KingTower;
import entity.tower.PrincessTower;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.ArrayList;

public class ClashRoyale {
    private RenderWindow window;
    private int window_width = 1280;
    private int window_height = 720;
    public static Vector2f mousepos;
    public Arena arena = new Arena();
    private Troops current_troops = null;
    private boolean CanDrop = false;
    private boolean mousePressed = false;
    public ArrayList<Entity> entities = new ArrayList<>();
    private float elixir;
    public float elixir_generation = 1;
    private float starting_elixir=5;
    private RectangleShape elixirbar = new RectangleShape();
    private RectangleShape current_elixir = new RectangleShape();
    private RectangleShape rectangleShape = new RectangleShape(new Vector2f(100,100));
    private Clock elixir_time = new Clock();

    public static int clicked_tile_x = 4;
    public static int clicked_tile_y = 17;
    public static boolean isDrop = false;

    public static float dt;
    public ClashRoyale()
    {
        window = new RenderWindow(new VideoMode(window_width,window_height), "ClashRoyale");
        Timer.clock.restart();
        rectangleShape.setPosition(550, 400);
        window.setFramerateLimit(30);
        initTowers();
        elixirbar.setSize(new Vector2f(100f,20f));
        elixirbar.setFillColor(Color.WHITE);
        current_elixir.setFillColor(Color.MAGENTA);
        elixirbar.setPosition(new Vector2f(0,window_height - 20));
        current_elixir.setPosition(elixirbar.getPosition());

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
        if(elixir_time.getElapsedTime().asSeconds() >= 0.24f/elixir_generation && elixir < 10)
        {
            elixir_time.restart();
            elixir = elixir + 0.1f;
        }
        current_elixir.setSize(new Vector2f(elixir*10f, 20f));
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
        arena.tick();
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
        window.draw(elixirbar);
        window.draw(current_elixir);
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
                    log.setPosition(arena.tiles[clicked_tile_x][clicked_tile_y].getCenter().x,arena.tiles[clicked_tile_x][clicked_tile_y].getCenter().y);
                    isDrop = true;
                    entities.add(log);
                    current_troops = null;
                    CanDrop = false;
                    break;
                case KNIGHT:
                    Knight knight = new Knight();
                    knight.setPosition(mousepos.x, mousepos.y);
                    isDrop = true;
                    knight.setSpawn();
                    entities.add(knight);
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
                   if( e.hurt(entities.get(i).getDamage(), entities.get(i).attack())) {

                       System.out.println("Collisione tra " + e.toString() + " e " + entities.get(i).toString() + " per " + entities.get(i).getDamage() + " di danno ");
                   }
                }

            }
        }
    }
}
