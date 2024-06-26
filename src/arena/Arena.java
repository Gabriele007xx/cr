package arena;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import state.ClashRoyale;

import java.util.ArrayList;

public class Arena {
    private ArrayList<ArrayList<Tile>> tiles_arena = new ArrayList<ArrayList<Tile>>();
    public Tile[][] tiles = new Tile[20][33];
    public Arena()
    {
        initializeArenaTiles();
    }
    private void initializeArenaTiles()
    {
        boolean Dark=false;
      for(int i=0;i<=19;i++)
      {
          tiles_arena.add(new ArrayList<Tile>());
          for(int j=0;j<=32;j++)
          {
              Tile tile = new Tile(i,j);

              tile.getShape().setSize(new Vector2f(Tile.TILE_SIZE, Tile.TILE_SIZE));
              //Disegna il taglio superiore
              if(j == 0 && ((i >= 0 && i <=6) || (i>= 13 && i<= 18)))
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
              //Disegna le bande laterali
              else if ((i==0 || i==19) && (j>=0 && j <= 31))
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
              //Fiume
              else if((j == 15 || j == 16) && ((i >= 0 && i <=3) || (i>= 5 && i<= 14) || (i >= 16 && i <= 19)))
              {
                  tile.getShape().setFillColor(Color.BLUE);
                  if(Dark)
                  {
                      Dark = false;
                  }
                  else
                  {
                      Dark = true;
                  }
              }
              else if((j==14 || j== 17) && (i == 1 || i == 18))
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
              //Disegna il taglio inferiore
             else if(j == 32 && ((i >= 0 && i <=6) || (i>= 13 && i<= 18)))
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
              tiles[i][j] = tile;
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
    public void tick()
    {
        for(ArrayList<Tile> a : tiles_arena)
        {
            for(Tile t : a)
            {
                t.tick();
            }

        }
    }
}
