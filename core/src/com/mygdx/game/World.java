package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class World{
    Cha cha;
    ArrayList<Enemy> Enemy1;
    ArrayList<Bullet> bullet;
    ArrayList<EnemyBullet> Ebullet;
    ArrayList<Bullet> RemoveBullet = new ArrayList<Bullet>();
   	ArrayList<Enemy> RemoveEnemy = new ArrayList<Enemy>();
    private ProjectGame projectGame;
    long timeStampB = TimeUtils.millis();
    long timeStampC = TimeUtils.millis();
    boolean checkDelayBullet = false;
    boolean checkDelayCollision = false;
    boolean checkBoss = false;
    public static int score = 0;
    public String textScore = "SCORE : 0";
    //int j = 0,i = 0;

    World(ProjectGame projectGame){
        this.projectGame = projectGame;
        cha = new Cha(500,100);
        bullet = new ArrayList<Bullet>();
        Enemy1 = new ArrayList<Enemy>();
        Ebullet = new ArrayList<EnemyBullet>();
    }
    
    void update() {
    	updateCha();
        updateBullet();
        updateEnemy();
        updatepattern();
       // System.out.println(Enemy1.get(0).LIFE);
    }
   
    void updatepattern() {
    	if(score >= 20 && Enemy1.isEmpty()){  		
    		if(checkBoss == false){
    			Ebullet.clear();
    			Enemy1.add(new Boss(400,650));
    		}
    		checkBoss = true;
    		patternBoss();
    	}
    	else if(checkBoss == false){
    		pattern1();
    	}
	}

	private void patternBoss(){
		
	}

	private void pattern1() {
		if(Math.random() >= 0.95 && score < 20){
			Enemy1.add(new Enemy(0,650));
		}
		for(Enemy e: Enemy1){
			if(Math.random() >= 0.96){
				Ebullet.add(new EnemyBullet(e.position.x,e.position.y));
			}
			e.position.x += 4;			
		}		
		
		for(EnemyBullet b: Ebullet){
				b.Release(2);
		}
		
		updateEbullet();
	}

	private void updateEbullet() {
		ArrayList<EnemyBullet> RemoveEB = new ArrayList<EnemyBullet>();
		for(EnemyBullet b: Ebullet){
			if(b.check == true)
				RemoveEB.add(b);
		}
		Ebullet.removeAll(RemoveEB);
	}

	void updateCha(){
    	updateChaPosition();
    	updateShoot();
    	updateCollision();
    }

	private void updateCollision() {
		if(checkDelayCollision == false){
    		timeStampC = TimeUtils.millis();
    		checkDelayCollision = true;
    	}
		for(Enemy e: Enemy1){
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timeStampC >3000){
    			//System.out.println("kuy" + i++);
    			checkDelayCollision = false;
    			cha.LIFE--;
			}
		}
		for(EnemyBullet e: Ebullet){
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timeStampC >3000){
    			//System.out.println("kuy" + i++);
    			checkDelayCollision = false;
    			cha.LIFE--;
			}
		}
	}

	private void updateShoot() {
		if(checkDelayBullet == false){
    		timeStampB = TimeUtils.millis();
    		checkDelayBullet = true;
    	}
        if(Gdx.input.isKeyPressed(Keys.Z) && TimeUtils.millis() - timeStampB > 75) {       	
        	bullet.add(new Bullet(cha.position.x,cha.position.y));
        	checkDelayBullet = false;
        }
	}

	private void updateChaPosition() {
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
        if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
        	cha.SLOW = 2;
        }
        else
        	cha.SLOW = 1;
	}

    void updateBullet(){   	
    	for(Bullet b: bullet){
    		b.Release();
    		if(b.check == true)
    			RemoveBullet.add(b);
    	}
    	bullet.removeAll(RemoveBullet);
    }
    
    void updateEnemy(){
    	for(Enemy e: Enemy1){
    		for(Bullet b: bullet){
    			if(checkCollision(e.position.x, b.position.x,e.position.y,b.position.y)){
    				e.LIFE--;
    				RemoveBullet.add(b);
    				if(e.LIFE == 0){
    					RemoveEnemy.add(e);
    					
    					score++;
    					textScore = "SCORE : " + score;
    				}
    			}		
        	}
    	if(e.isOut())
    		RemoveEnemy.add(e);
    	}
    	Enemy1.removeAll(RemoveEnemy);
    	bullet.removeAll(RemoveBullet);
    }
	
	private boolean checkCollision(float x, float x2 ,float y, float y2) {
		return Math.pow((x - x2),2) + Math.pow((y - y2),2) <= 1000;
	}
    
    Cha getCha() {
        return cha;
    }
}
