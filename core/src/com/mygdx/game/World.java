package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World{
    Cha cha;
    ArrayList<GameObject> Obj;
    ArrayList<Enemy> Enemy1;
    ArrayList<Bullet> bullet;
    ArrayList<EnemyBullet> Ebullet;
    private ProjectGame projectGame;
    long timerB = TimeUtils.millis();
    long timerC = TimeUtils.millis();
    boolean checkDelayBullet = false;
    boolean checkDelayCollision = false;
    public static int score = 0;
    public String textScore = "SCORE : 0";
    //int j = 0,i = 0;

    World(ProjectGame projectGame){
        this.projectGame = projectGame;
        cha = new Cha(500,100);
        bullet = new ArrayList<Bullet>();
        Enemy1 = new ArrayList<Enemy>();
        Ebullet = new ArrayList<EnemyBullet>();
        Obj = new ArrayList<GameObject>();
    }
    
    void update() {
    	updateCha();
        updateBullet();
        updateEnemy();
        updatepattern();
        Obj.add(new Enemy(0,600));
    }
   
    void updatepattern() {
    	pattern1();
	}

	private void pattern1() {
		if(Math.random() >= 0.95){
			Enemy1.add(new Enemy(0,600));
		}
		for(Enemy e: Enemy1){
			if(Math.random() >= 0.96){
				Ebullet.add(new EnemyBullet(e.position.x,e.position.y));
			}
			e.position.x += 5;			
		}
		ArrayList<EnemyBullet> RemoveEB = new ArrayList<EnemyBullet>();
		for(EnemyBullet b: Ebullet){
			b.Release(2);
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
    		timerC = TimeUtils.millis();
    		checkDelayCollision = true;
    	}
		for(Enemy e: Enemy1){
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timerC >3000){
    			//System.out.println("kuy" + i++);
    			checkDelayCollision = false;
    			cha.LIFE--;
			}
		}
		for(EnemyBullet e: Ebullet){
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timerC >3000){
    			//System.out.println("kuy" + i++);
    			checkDelayCollision = false;
    			cha.LIFE--;
			}
		}
	}

	private void updateShoot() {
		if(checkDelayBullet == false){
    		timerB = TimeUtils.millis();
    		checkDelayBullet = true;
    	}
        if(Gdx.input.isKeyPressed(Keys.X) && TimeUtils.millis() - timerB > 75) {       	
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
        if(Gdx.input.isKeyPressed(Keys.Z)) {
        	cha.SLOW = 2;
        }
        else
        	cha.SLOW = 1;
	}

    void updateBullet(){
    	ArrayList<Bullet> Removebullet = new ArrayList<Bullet>();
    	for(Bullet b: bullet){
    		b.Release();
    		if(b.check == true)
    			Removebullet.add(b);
    	}
    	bullet.removeAll(Removebullet);
    }
    
    void updateEnemy(){
    	ArrayList<Enemy> RemoveE = new ArrayList<Enemy>();
    	for(Enemy e: Enemy1){
    		for(Bullet b: bullet){
    			if(checkCollision(e.position.x, b.position.x,e.position.y,b.position.y)){
    				RemoveE.add(e);
    				score++;
    				textScore = "SCORE : " + score;
    			}
    			if(b.isOut())
    				RemoveE.add(e);
        	}
    	}
    	Enemy1.removeAll(RemoveE);
    }
	
	private boolean checkCollision(float x, float x2 ,float y, float y2) {
		return Math.pow((x - x2),2) + Math.pow((y - y2),2) <= 1000;
	}
    
    Cha getCha() {
        return cha;
    }
}
