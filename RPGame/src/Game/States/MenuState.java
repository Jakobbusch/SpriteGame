package Game.States;

import Game.*;
import Game.GFX.Assets;
import Game.UI.ClickListener;
import Game.UI.UIImageButton;
import Game.UI.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(250, 200, 128*3, 64*3, Assets.button_start, new ClickListener() {
            @Override
            public void onCLick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
