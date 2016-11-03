package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer 
{
	public SpriteBatch batch;
	//private ProjectGame projectGame;
	private World world;
	public BitmapFont showScore;
	
	public WorldRenderer(SpriteBatch batch,World world, BitmapFont showScore)
	{
		//this.projectGame=projectGame;
		this.batch = batch;
		this.world = world; 
		this.showScore = showScore;
	}
	
	public void render()
	{
		//batch = new SpriteBatch();
		batch.begin();
        Vector2 pos = world.cha.getPosition();
        batch.draw(Asset.BgImg,0,0, 1000, 1000);
        batch.end();
        
        if(world.checkDelayCollision == true)
        {
        	batch.begin();
        	batch.draw(Asset.ChaImg, pos.x, pos.y,50,50);
        	batch.end();
        }
        else	
        {
        	batch.begin();
        	batch.draw(Asset.ChaHurtImg, pos.x, pos.y,50,50);
        	batch.end();
        }
        
        batch.begin(); 
        showScore.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        showScore.draw(batch,world.textScore,800,700,100,100,true); 
        batch.end();
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
	
	public void renderEBullet()
	{
		for(EnemyBullet b : world.Ebullet)
		{
			//batch = new SpriteBatch();
			batch.begin();
	        Vector2 pos =b.getPosition();
	        batch.draw(Asset.BulletImg, pos.x, pos.y,50,50);
	        batch.end();
		}
	}
	
	
}
