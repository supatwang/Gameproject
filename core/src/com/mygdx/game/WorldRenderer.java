package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public SpriteBatch batch;
	private World world;
	public BitmapFont showScore;
	
	public WorldRenderer(SpriteBatch batch,World world, BitmapFont showScore){
		this.batch = batch;
		this.world = world; 
		this.showScore = showScore;
	}
	
	public void render(){
		renderBackground(); 
        renderCha();
        renderScore();
        renderBullet();
        Enemyrender();
        renderEnemyBullet(); 
	}

	private void renderScore() {
		batch.begin(); 
        showScore.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        showScore.draw(batch,world.textScore,900,700);
        showScore.draw(batch,"LIFE : " + world.cha.LIFE,900,600);
        batch.end();
	}

	private void renderCha() {
		Vector2 pos = world.cha.getPosition();
        if(world.checkDelayCollision == true){
        	batch.begin();
        	batch.draw(Asset.ChaImg, pos.x, pos.y,50,50);
        	batch.end();
        }
        else{
        	batch.begin();
        	batch.draw(Asset.ChaHurtImg, pos.x, pos.y,50,50);
        	batch.end();
        }
	}

	private void renderBackground() {
		batch.begin();
        batch.draw(Asset.BgImg,0,0,1000,1000);
        batch.end();
	}
	
	public void Enemyrender(){
		for(Enemy e : world.Enemy1 ){	
			batch.begin();
        	Vector2 pos = e.getPosition();
        	batch.draw(Asset.Enemy1, pos.x, pos.y,75,75);
        	batch.end();
		}
	}
	
	public void renderBullet(){
		for(Bullet b : world.bullet){
			batch.begin();
	        Vector2 pos = b.getPosition();
	        batch.draw(Asset.BulletImg, pos.x, pos.y,50,50);
	        batch.end();
		}
	}
	
	public void renderEnemyBullet(){
		for(EnemyBullet b : world.Ebullet){
			batch.begin();
	        Vector2 pos = b.getPosition();
	        batch.draw(Asset.EnemyBullet, pos.x, pos.y,25,25);
	        batch.end();
		}
	}
	
	public void renderRetryScreen(){
			batch.begin();
			batch.draw(Asset.tryAgain,0,0,500,500);
			batch.draw(Asset.bobo,500,0,500,500);
	        batch.end();
	}
	
	public void renderWInScreen(){
		batch.begin();
		batch.draw(Asset.winScreen,100,0,900,700);
        batch.end();
}
	
	
}
