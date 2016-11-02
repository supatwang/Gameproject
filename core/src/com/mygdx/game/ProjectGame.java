package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ProjectGame extends Game
{
	public SpriteBatch batch;
	//private World world = new World(this);
	//private WorldRenderer worldrenderer = new WorldRenderer(this, world);
		
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		Asset.load();
		
	}

	@Override
	public void render ()
	{
		//Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
        // world.update();
        //worldrenderer.render();
        //worldrenderer.renderBullet();
        //worldrenderer.Erender();
        		
	}
	
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}
