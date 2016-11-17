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
    long timeStampD = TimeUtils.millis();
    boolean checkDelayBullet = false;
    boolean checkDelayCollision = false;
    boolean checkBoss = false;
    boolean firstDelay = true;
    public static int score = 0;
    public String textScore = "SCORE : 0";
	int isRightBorder = 1;
	int bulletcase = 0;
	int state;
    //int j = 0,i = 0;

    World(ProjectGame projectGame){
        this.projectGame = projectGame;
        this.state = 0;
        cha = new Cha(500,100);
        bullet = new ArrayList<Bullet>();
        Enemy1 = new ArrayList<Enemy>();
        Ebullet = new ArrayList<EnemyBullet>();
    }
    
    void update() {
    	updatestate();
    	updateCha();
        updateBullet();
        updateEnemy();
        updatepattern();
    }
   
    private void updatestate() {
		if(cha.LIFE <= 0)
			state = 1;
	}

	void updatepattern() {
    	if(score >= 20){  		
    		if(checkBoss == false){
    			Enemy1.clear();
    			Ebullet.clear();
    			Enemy1.add(new Boss(400,650));
    		}
    		checkBoss = true;
    		if(Enemy1.get(0).LIFE < 80 && Enemy1.get(0).LIFE > 15)
    			patternBoss2();
    		else if(Enemy1.get(0).LIFE <= 20)
    			patternBoss(10,0.85);
    		else
    			patternBoss(8,0.95);
    		System.out.println(Enemy1.get(0).LIFE);
    	}
    	else if(checkBoss == false){
    		pattern1();
    	}
    	
	}

    private void patternBoss2(){
    	if(firstDelay){
    		timeStampD = TimeUtils.millis();
    		firstDelay = false;
    	}
    	if(TimeUtils.millis()-timeStampD < 2000)
			return;
		else{	
			if(Ebullet.size() < 69){
				moveBoss(16);
				if(Math.random() >= 0.9){
					Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
					Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
					Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
				}
				for(EnemyBullet b: Ebullet){
					b.Release(2,10,5);
					if(b.position.y == 500)
						b.position.y = 510;
				}
			}
			else{
				for(EnemyBullet b: Ebullet){
					b.Release(++bulletcase %3,2,1);
				}
				if(Ebullet.get(0).position.y < 0)
					Ebullet.clear();
			}
		}
    }
    
    private void patternBoss(int speed, double random){
    	if(firstDelay){
    		timeStampD = TimeUtils.millis();
    		firstDelay = false;
    	}
    	if(TimeUtils.millis()-timeStampD < 2000)
			return;
		else{
				moveBoss(speed);
				shootBossBullet(random);
		}
    	if(Enemy1.get(0).LIFE <= 5)
    		state = 2;
	}

	private void shootBossBullet(double random) {
		if(Math.random() >= random){
			Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
			Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
			Ebullet.add(new EnemyBullet(Enemy1.get(0).position.x,Enemy1.get(0).position.y));
		}
		for(EnemyBullet b: Ebullet){
			b.Release(++bulletcase %3,10,5);
		}
	}
	
    private void moveBoss(int speed) {
    	if(Enemy1.get(0).position.x >= 785 && Enemy1.get(0).position.x <= 800)
    		isRightBorder = 2;
    	if(Enemy1.get(0).position.x <= 10 && Enemy1.get(0).position.x >= 0)
    		isRightBorder = 1;
    	switch(isRightBorder){
    	case 1:
    		Enemy1.get(0).position.x += speed;
    		break;
    	case 2:
    		Enemy1.get(0).position.x -= speed;
    		break;
    	}

	}

	private void pattern1() {
		if(Math.random() >= 0.95 && score < 20){
			Enemy1.add(new Enemy(0,650));
		}
		for(Enemy e: Enemy1){
			if(Math.random() >= 0.96){
				Ebullet.add(new EnemyBullet(e.position.x,e.position.y));
			}
			e.position.x += 5;			
		}		
		for(EnemyBullet b: Ebullet){
				b.Release(2,10,5);
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
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timeStampC > 3000){
    			checkDelayCollision = false;
    			cha.LIFE--;
			}
		}
		for(EnemyBullet e: Ebullet){
			if(checkCollision(cha.position.x, e.position.x,cha.position.y,e.position.y) && TimeUtils.millis() - timeStampC > 3000){
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
        long bulletSpeed = 100/cha.SLOW;
		if(Gdx.input.isKeyPressed(Keys.Z) && (TimeUtils.millis() - timeStampB) > bulletSpeed) {       	
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
