package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer 
{
	public SpriteBatch batch;
	//private ProjectGame projectGame;
	private World world;
	
	public WorldRenderer(SpriteBatch batch,World world)
	{
		//this.projectGame=projectGame;
		this.batch = batch;
		this.world = world; 
	}
	public void Erender()
	{
		for(Enemy e : world.Enemy1 )
		{	
			//batch = new SpriteBatch();
			batch.begin();
        	Vector2 pos = e.getPosition();
        	batch.draw(Asset.ChaImg, pos.x, pos.y,50,50);
        	batch.end();
		}
	}
	public void render()
	{
		//batch = new SpriteBatch();
		batch.begin();
        Vector2 pos = world.cha.getPosition();
        batch.draw(Asset.ChaImg, pos.x, pos.y,50,50);
        batch.end();
	}
	public void renderBullet()
	{
		for(Bullet b : world.bullet)
		{
			//batch = new SpriteBatch();
			batch.begin();
	        Vector2 pos =b.getPosition();
	        batch.draw(Asset.BulletImg, pos.x, pos.y,50,50);
	        batch.end();
		}
	}
	
	
}
