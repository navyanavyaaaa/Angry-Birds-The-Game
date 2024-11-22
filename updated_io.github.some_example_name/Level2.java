package io.github.some_example_name;

import io.github.some_example_name.Classes.Bird;
import io.github.some_example_name.Classes.Catapult;
import io.github.some_example_name.Classes.Block;
import io.github.some_example_name.Classes.Pig;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;




/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Level2 implements Screen {
    private SpriteBatch batch;
    private Texture image;
    private final Game game;
    SpriteBatch spriteBatch;
    FitViewport viewport;

    Rectangle BirdRed;
    Rectangle BirdBomb;
    Rectangle SmallPig;
    Rectangle BigPig;
    Texture redTexture;

    Texture bg;
    Texture bombTexture;
    Texture smallPig;
    Texture bigPig;
    Texture wood1;
    Texture wood2;
    Texture wood3;
    Texture wood4;
    Texture winTexture;
    Texture loseTexture;
    Texture loseScreenTexture;
    Texture winScreenTexture;
    Texture nextLevelTexture;
    Texture backTexture;
    Texture retryTexture;
    Texture MenuTexture;
    Texture ground;

    Sprite birdSprite;
    Sprite bigPigSprite;
    Sprite smallPigSprite;
    Sprite cataSprite;
    Sprite wood1Sprite;
    Sprite wood2Sprite;
    Sprite wood3Sprite;
    Sprite wood4Sprite;
    Sprite winSprite;
    Sprite loseSprite;
    Sprite winScreen;
    Sprite loseScreen;
    Sprite nextLevel;
    Sprite backSprite;
    Sprite retrySprite;
    Sprite menuSprite;

    Catapult catapult;
    Block glassOne;
    Block glassTwo;
    Block glassThree;
    Block woodOne;
    Block woodTwo;
    Block woodThree;
    Block woodOne2;
    Pig smallpig;
    Pig smallpig2;
    Pig bigpig;
    Bird redbird;
    Bird redbird1;
    Bird bombbird;

    int winScreenDraw = 0;
    String theme;


    public Level2(Game game,String s) {
        this.game = game;
        if (s.equals("night.png") || s.equals("night_resume.png")) {
            this.bg = new Texture("night.jpg");
        } else if (s.equals("day.png") || s.equals("day_resume.png")){
            this.bg = new Texture("bga.jpg");
        } else if (s.equals("spooky.png") || s.equals("spooky_resume.png")){
            this.bg = new Texture("halloween.png");
        }

        this.theme= s;

    }


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(800, 500);
        ground = new Texture("ground.jpg");

        nextLevelTexture = new Texture("nextlevel.png");
        nextLevel = new Sprite(nextLevelTexture);
        nextLevel.setSize(1.4f*100,0.5f*100);

        retryTexture = new Texture("retry.png");
        retrySprite = new Sprite(retryTexture);
        retrySprite.setSize(1.4f*100,0.5f*100);

        backTexture = new Texture("back.png");
        backSprite = new Sprite(backTexture);
        backSprite.setSize(0.5f*100,0.5f*100);

        MenuTexture = new Texture("menu.png");
        menuSprite= new Sprite(MenuTexture);
        menuSprite.setSize(0.7f*100,0.7f*100);

        winScreenTexture = new Texture("winoverlay.png");
        winScreen = new Sprite(winScreenTexture);
        winScreen.setSize(2.5f*100,3.5f*100);

        loseScreenTexture = new Texture("loseoverlay.png");
        loseScreen = new Sprite(loseScreenTexture);
        loseScreen.setSize(4f*100,3.5f*100);

        winTexture = new Texture("win.png");
        winSprite = new Sprite(winTexture);
        winSprite.setSize(1f*75,1f*43);

        loseTexture = new Texture("lose.png");
        loseSprite = new Sprite(loseTexture);
        loseSprite.setSize(1f*75,1f*43);

        redbird = new Bird("red");
        redbird.setTexture("birdred.png");
        redbird.setSize(75.0f,75.0f);

        redbird1 = new Bird("red");
        redbird1.setTexture("birdred.png");
        redbird1.setSize(75.0f,75.0f);

        bombbird = new Bird("bomb");
        bombbird.setTexture("chuck.png");
        bombbird.setSize(1f,1f);

        smallpig = new Pig("small");
        smallpig.setTexture("small.png");
        smallpig.setSize(.40f*100,.40f*100);

        smallpig2 = new Pig("small");
        smallpig2.setTexture("small.png");
        smallpig2.setSize(.40f*100,.40f*100);

        bigpig = new Pig("big");
        bigpig.setTexture("jaitrika.png");
        bigpig.setSize(.75f*100,.75f*100);

        catapult = new Catapult();
        catapult.setTexture("catapult.png");
        catapult.setSize(.75f*100,1.5f*100);

        woodTwo = new Block("wood",2);
        woodTwo.setTexture("wood2.png");
        woodTwo.setSize(1*100,.2f*100);

        woodOne = new Block("wood",1);
        woodOne.setTexture("wood1.png");
        woodOne.setSize(1f*100,1f*100);

        woodThree = new Block("wood",3);
        woodThree.setTexture("wood3.png");
        woodThree.setSize(1f*100,1f*100);;

        woodOne2 = new Block("wood",1);
        woodOne2.setTexture("wood1.png");
        woodOne2.setSize(1f*100,1f*100);

        glassTwo = new Block("glass",2);
        glassTwo.setTexture("glass2.png");
        glassTwo.setSize(1*100,.2f*100);

        glassOne = new Block("glass",1);
        glassOne.setTexture("glass1.png");
        glassOne.setSize(1f*100,1f*100);

        glassThree = new Block("glass",1);
        glassThree.setTexture("glass3.png");
        glassThree.setSize(1f*100,1f*100);
    }

    @Override
    public void render(float delta) {
        draw();
        input();
    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i, i1, true);
    }

    public void drawwin(){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        spriteBatch.draw(bg, 0, 0, worldWidth, worldHeight);

        spriteBatch.end();
    }

    public void input(){

        Rectangle birdspriteBounds = redbird.sprite.getBoundingRectangle();
        Rectangle winspriteBounds = winSprite.getBoundingRectangle();
        Rectangle losespriteBounds = loseSprite.getBoundingRectangle();
        Rectangle nextLevelBounds = nextLevel.getBoundingRectangle();
        Rectangle retrySpriteBounds = retrySprite.getBoundingRectangle();
        Rectangle backSpriteBounds = backSprite.getBoundingRectangle();
        Rectangle MenuBounds = menuSprite.getBoundingRectangle();

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            if (winScreenDraw==1){
                if (nextLevelBounds.contains(mousePos.x, 500-mousePos.y)){
                    System.out.println("Go to Next Level");
                } else if (backSpriteBounds.contains(mousePos.x, 500-mousePos.y)) {
                    game.setScreen(new LevelMap_Resume(game, "night_resume.png"));
                }
            } else if (winScreenDraw==2) {
                if (retrySpriteBounds.contains(mousePos.x, 500-mousePos.y)){
                    game.setScreen(new Level2(this.game,theme));
                } else if (backSpriteBounds.contains(mousePos.x, 500-mousePos.y)) {
                    game.setScreen(new LevelMap_Resume(game, "night_resume.png"));
                }
            }

            if (winspriteBounds.contains(mousePos.x, 500-mousePos.y)) {
                System.out.println("Mouse click is overlapping with the sprite!"+mousePos.x+"   "+mousePos.y);
                winScreenDraw=1;

            } else if (losespriteBounds.contains(mousePos.x, 500-mousePos.y)) {
                System.out.println("Mouse click is overlapping with the sprite!"+mousePos.x+"   "+mousePos.y);
                winScreenDraw=2;

            } else if (MenuBounds.contains(mousePos.x,500-mousePos.y)){
                System.out.println("Go to Menu");
                //game.setScreen(new Menu(this.game,2));

            }
        }
    }

    public void draw(){
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        spriteBatch.draw(bg, 0, 0, worldWidth, worldHeight);
        spriteBatch.draw(ground, 0, 0, worldWidth, 122);

        nextLevel.setPosition(3.3f*100,.8f*100);
        backSprite.setPosition(2.7f*100,.8f*100);
        retrySprite.setPosition(3.3f*100,.8f*100);

        winScreen.setPosition(2.5f*100,1f*100);
        loseScreen.setPosition(2f*100,1f*100);

        winSprite.setPosition(2.7f*100,4f*100);
        winSprite.draw(spriteBatch);

        loseSprite.setPosition(3.7f*100,4f*100);
        loseSprite.draw(spriteBatch);

        catapult.setPos(1f*100,1.20f*100);
        catapult.sprite.draw(spriteBatch);

        redbird.setPos(1f*100f,2.35f*100);
        redbird.sprite.draw(spriteBatch);

        redbird1.setPos(0.6f*100f,1.2f*100);
        redbird1.sprite.draw(spriteBatch);

        bombbird.setPos(1.2f*100f,1.2f*100);
        bombbird.sprite.draw(spriteBatch);

        bigpig.setPos(4.6f*100,2.35f*100);
        bigpig.sprite.draw(spriteBatch);

        smallpig.setPos(5.8f*100,1.4f*100);
        smallpig.sprite.draw(spriteBatch);

        smallpig2.setPos(5.8f*100,2.55f*100);
        smallpig2.sprite.draw(spriteBatch);

        woodOne.setPos(5.5f*100,1.2f*100);
        woodOne.sprite.draw(spriteBatch);

        woodOne2.setPos(5.5f*100,2.35f*100);
        woodOne2.sprite.draw(spriteBatch);

        woodTwo.setPos(5.5f*100,2.18f*100);
        woodTwo.sprite.draw(spriteBatch);

        glassTwo.setPos(4.5f*100,2.18f*100);
        glassTwo.sprite.draw(spriteBatch);

        woodThree.setPos(4.5f*100,1.2f*100);
        woodThree.sprite.draw(spriteBatch);

        glassThree.setPos(5.5f*100,3.3f*100);
        glassThree.sprite.draw(spriteBatch);

        glassOne.setPos(6.5f*100,1.2f*100);
        glassOne.sprite.draw(spriteBatch);

        menuSprite.setPosition(0.2f*100,4.1f*100);
        menuSprite.draw(spriteBatch);

        if (winScreenDraw==1) {
            winScreen.draw(spriteBatch);
            nextLevel.draw(spriteBatch);
            backSprite.draw(spriteBatch);
        } else if (winScreenDraw==2){
            loseScreen.draw(spriteBatch);
            retrySprite.draw(spriteBatch);
            backSprite.draw(spriteBatch);
        }

        //spriteBatch.draw(redTexture,0,0,1,1);
        spriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
