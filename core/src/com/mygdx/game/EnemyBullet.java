package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends Bullet {
	
	public EnemyBullet(Vector2 x) {
		super(x);
	}
	public void Release(int i)
	{
		//System.out.println(i);
		switch(i) {
        case 1:
        	position.y -= 10 + World.score/20;
        	position.x -= 10 + World.score/20;
            break;
        case 2:
        	position.y -= 10 + World.score/20;
            break;
        case 0:
        	position.y -= 10 + World.score/20;
        	position.x += 10 + World.score/20;
            break;
        }
		
		if(position.y <= 0)
			check = true;
	}
}
