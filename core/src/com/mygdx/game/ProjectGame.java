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
        super.render();   		
	}
	
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}
