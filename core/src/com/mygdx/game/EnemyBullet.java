package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends Bullet {
	
	public EnemyBullet(float x,float y) {
		super(x,y);
	}
	public void Release(int i){
		//System.out.println(i);
		switch(i) {
        case 1:
        	position.y -= 10;
        	position.x -= 10;
            break;
        case 2:
        	position.y -= 10;
            break;
        case 0:
        	position.y -= 10;
        	position.x += 10;
            break;
        }
		
		if(isOut())
		check = true;
	}
}
