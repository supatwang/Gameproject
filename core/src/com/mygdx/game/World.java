package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World
{
    Cha cha;
    ArrayList<Enemy> Enemy1;
    ArrayList<Bullet> bullet;
    private ProjectGame projectGame;
    long timerB = TimeUtils.millis();
    long timerC = TimeUtils.millis();
    boolean checkDelayBullet = false;
    boolean checkDelayCollision = false;
    int i=0;

    World(ProjectGame projectGame) {
        this.projectGame = projectGame;
        cha = new Cha(100,100);
        bullet = new ArrayList<Bullet>();
        Enemy1 = new ArrayList<Enemy>();
        for(int i=0;i<55;i++)
        {
        	Enemy1.add(new Enemy((int)(Math.random()*1500),(int)(Math.random()*1500)));
        }
    }
    
    void update() 
    {
    	updateCha();
        updateBullet();
        updateEnemy();
    }
    void updateCha()
    {
    	if(checkDelayBullet==false)
    	{
    		timerB = TimeUtils.millis();
    		checkDelayBullet = true;
    		
    	}
    	if(checkDelayCollision==false)
    	{
    		timerC = TimeUtils.millis();
    		checkDelayCollision = true;
    		
    	}
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            cha.move(Cha.DIRECTION_LEFT);
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            cha.move(Cha.DIRECTION_UP);
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            cha.move(Cha.DIRECTION_DOWN);
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	cha.move(Cha.DIRECTION_RIGHT);
        }
        if(Gdx.input.isKeyPressed(Keys.Z) && TimeUtils.millis() - timerB > 75) 
        {       	
        	
        	bullet.add(new Bullet(cha.getPosition()));
        	checkDelayBullet= false;
        }
		for(Enemy e:Enemy1)
    	{
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timerC >3000)
			{
    			System.out.println("kuy" + i++);
    			checkDelayCollision = false;
			}
		}
    }

    void updateBullet()
    {
    	ArrayList<Bullet> Removebullet = new ArrayList<Bullet>();
    	for(Bullet b:bullet)
    	{
    		b.Release();
    		if(b.check==true)
    			Removebullet.add(b);
    	}
    	bullet.removeAll(Removebullet);
    	
    	
    }
    void updateEnemy()
    {
    	ArrayList<Enemy> RemoveE = new ArrayList<Enemy>();
    	for(Enemy e: Enemy1)
    	{
    		for(Bullet b:bullet)
        	{
    			if(checkCollision(e.position.x, b.position.x,e.position.y,b.position.y))
        			RemoveE.add(e);
        	}
    	}
    	Enemy1.removeAll(RemoveE);
    	
    }
	/*private boolean checkDelay(boolean check,int delayTime) {
		if(check==false)
    	{
    		timer = TimeUtils.millis();
    		checkDelayBullet = true;
    		
    	}
		if(TimeUtils.millis() - timer > delayTime)
			return true;
		else
			return false;
	}*/

	private boolean checkCollision(float x, float x2 ,float y, float y2) {
		return Math.pow((x-x2),2)+Math.pow((y-y2),2) <= 1000;
	}
    
    Cha getCha() 
    {
        return cha;
    }
}
