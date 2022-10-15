package arena;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;

public class Arena {
    private ArrayList<ArrayList<Tile>> tiles_arena = new ArrayList<ArrayList<Tile>>();
    public Arena()
    {
        initializeArenaTiles();
    }
    private void initializeArenaTiles()
    {
        boolean Dark=false;
      for(int i=0;i<=10;i++)
      {
          tiles_arena.add(new ArrayList<Tile>());
          for(int j=0;j<=10;j++)
          {
              Tile tile = new Tile();
              tile.getShape().setSize(new Vector2f(Tile.TILE_SIZE, Tile.TILE_SIZE));
              if(Dark)
              {
                 tile.getShape().setFillColor(Color.BLACK);
                 Dark = false;

              }
              else
              {
                  tile.getShape().setFillColor(Color.WHITE);
                  Dark=true;
              }
              tile.getShape().setPosition(i*Tile.TILE_SIZE, j*Tile.TILE_SIZE);
              tiles_arena.get(i).add(tile);
          }
      }
    }
    public void render(RenderTarget target)
    {
        for(ArrayList<Tile> tile : tiles_arena)
        {
            for(Tile t : tile)
            {
                t.render(target);
            }
        }
    }
}
