package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class GameObject {
	public Vector2 position;
	
	public GameObject (float x,float y){
		position = new Vector2(x,y);
	}	

	public Vector2 getPosition() {
		return position;    		
	}
	
	public boolean isOut(){
		if(position.y <= 0 || position.y > 700 || position.x <= -10 || position.x > 800)
			return true;
		else 
			return false;
	}
}
