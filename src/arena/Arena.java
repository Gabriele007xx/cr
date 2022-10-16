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
      for(int i=0;i<=18;i++)
      {
          tiles_arena.add(new ArrayList<Tile>());
          for(int j=0;j<=32;j++)
          {
              Tile tile = new Tile();
              tile.getShape().setSize(new Vector2f(Tile.TILE_SIZE, Tile.TILE_SIZE));
              if(j == 0 && ((i >= 0 && i <=7) || (i>= 12 && i<= 18)))
              {
                  tile.getShape().setFillColor(Color.RED);
                  if(Dark)
                  {
                      Dark = false;
                  }
                  else
                  {
                      Dark = true;
                  }
              }
              else
              {
                  if (Dark) {
                      tile.getShape().setFillColor(Color.BLACK);
                      Dark = false;

                  } else {
                      tile.getShape().setFillColor(Color.WHITE);
                      Dark = true;
                  }

              }
              tile.getShape().setPosition(i * Tile.TILE_SIZE, j * Tile.TILE_SIZE);
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
