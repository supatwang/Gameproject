package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class EnemyBullet extends Bullet {
	
	public EnemyBullet(Vector2 x) {
		super(x);
	}
	@Override
	public void Release()
	{
		position.y -= 1;
		if(position.y <= 0)
			check = true;
	}
}
