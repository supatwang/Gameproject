package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet
{

	public Vector2 position;
	public boolean check = false;
	public Bullet (Vector2 x)
	{
		position = new Vector2(x);
		position.x += 3;
	}
	public Vector2 getPosition() 
	{
		return position;    
	}
	public void Release()
	{
		position.y += 50;
		if(position.y > 1500)
			check = true;
	}
	//454545

}
