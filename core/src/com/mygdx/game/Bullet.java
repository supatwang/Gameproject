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
		position.y += 25;
		if(isOut())
			check = true;
	}
	public boolean isOut(){
		if(position.y <= 0 || position.y > 1500 || position.x <= -10 || position.x > 2010)
			return true;
		else 
			return false;
	}
	//454545

}
