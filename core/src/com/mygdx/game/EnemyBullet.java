package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends Bullet {
	
	public EnemyBullet(Vector2 x) {
		super(x);
	}
	public void Release()
	{
		//System.out.println(i);
		position.y -= 10 + World.score/5;
		if(position.y <= 0)
			check = true;
	}
}
