package Game.GFX;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;

    public static BufferedImage dirt, grass, stone, water,tree;
    public static BufferedImage[] player_down, player_up, player_left, player_right, player_down_stand, player_up_stand, player_left_stand, player_right_stand;
    public static BufferedImage[] button_start;

    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        SpriteSheet sheetPlayer = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
        SpriteSheet sheetTree = new SpriteSheet(ImageLoader.loadImage("/textures/Tileset.png"));
        SpriteSheet buttonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/button.png"));



        button_start = new BufferedImage[2];
        button_start[0] = buttonSheet.crop(160,178,400,200);
        button_start[1] = buttonSheet.crop(545,178,400,200);

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        player_down_stand = new BufferedImage[1];
        player_up_stand = new BufferedImage[1];
        player_left_stand = new BufferedImage[1];
        player_right_stand = new BufferedImage[1];



        player_down_stand[0] = sheetPlayer.crop(width * 1, height *4, width,height);


        player_up_stand[0] = sheetPlayer.crop(width * 1, height*7, width,height);


        player_left_stand[0] = sheetPlayer.crop(width * 1, height *5, width,height);


        player_right_stand[0] = sheetPlayer.crop(width * 1, height *6, width,height);



        player_down[0] = sheetPlayer.crop(width * 0, height *4, width,height);
        player_down[1] = sheetPlayer.crop(width * 2, height *4, width,height);

        player_up[0] = sheetPlayer.crop(width * 0, height*7, width,height);
        player_up[1] = sheetPlayer.crop(width * 2, height *7, width,height);

        player_left[0] = sheetPlayer.crop(width * 0, height *5, width,height);
        player_left[1] = sheetPlayer.crop(width * 2, height *5, width,height);

        player_right[0] = sheetPlayer.crop(width * 0, height *6, width,height);
        player_right[1] = sheetPlayer.crop(width * 2, height *6, width,height);

        tree = sheetTree.crop(0,0,width,height*2);

        dirt = sheet.crop(33,33*18,width,height);
        grass = sheet.crop(33,33,width,height);
        stone = sheet.crop(99,0,width,height);
        water = sheet.crop(33*8,33*7,width,height);



    }

}
