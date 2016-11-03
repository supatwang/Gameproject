package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ProjectGame extends Game
{
	public SpriteBatch batch;
	public BitmapFont showScore;
	
	@Override
	public void create () 
	{
		showScore = new BitmapFont();
		batch = new SpriteBatch();
		Asset.load();
		setScreen(new GameScreen(this));
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
