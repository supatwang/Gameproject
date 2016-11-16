package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends Bullet {
	
	public EnemyBullet(float x,float y) {
		super(x,y);
	}
	public void Release(int i,int speedY,int speedX){
		//System.out.println(i);
		switch(i) {
        case 1:
        	position.y -= speedY;
        	position.x -= speedX;
            break;
        case 2:
        	position.y -= speedY;
            break;
        case 0:
        	position.y -= speedY;
        	position.x += speedX;
            break;
        case 3:
        	position.y -= speedY;
        	position.x += speedX/2;
            break;
        case 4:
        	position.y -= speedY;
        	position.x -= speedX/2;
            break;
        }
		
		if(isOut())
		check = true;
	}
}
