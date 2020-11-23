package Game.Entities.Creatures;

import Game.GFX.Animation;
import Game.GFX.Assets;
import Game.*;
import Game.GFX.GameCamera.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //Animations
    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;

    private Animation animStandDown;
    private Animation animStandUp;
    private Animation animStandLeft;
    private Animation animStandRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;


        //Animations
        animDown = new Animation(400,Assets.player_down);
        animUp = new Animation(400,Assets.player_up);
        animLeft = new Animation(400,Assets.player_left);
        animRight = new Animation(400,Assets.player_right);

        animStandDown = new Animation(400,Assets.player_down_stand);
        animStandUp = new Animation(400,Assets.player_up_stand);
        animStandLeft = new Animation(400,Assets.player_left_stand);
        animStandRight = new Animation(400,Assets.player_right_stand);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();

        animStandDown.tick();
        animStandUp.tick();
        animStandLeft.tick();
        animStandRight.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

       // g.setColor(Color.red);
       // g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
         //       (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
           //     bounds.width, bounds.height);
    }


    private BufferedImage getCurrentAnimationFrame() {


        // the waiting animation only work for down atm. Need fixa

            int temp = 0;

            if (xMove < 0) {
                temp =1;
                return animLeft.getCurrentFrame();
            }



            if (xMove > 0) {
                temp = 2;
                return animRight.getCurrentFrame();
            }


            if (yMove < 0) {
                temp = 3;
                return animUp.getCurrentFrame();
            }

            if (yMove > 0) {
                temp = 4;
                return animDown.getCurrentFrame();
            }
         return animStandDown.getCurrentFrame();
    }
}
