package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Cha extends GameObject{
	public Cha(float x, float y){
		super(x, y);
	}

	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 10;
    public int SLOW = 1;
    public int LIFE = 5; 
    
	 public void move(int dir){ 
	        switch(dir) {
	        case DIRECTION_UP:
	            if(position.y < 700)
	        		position.y += SPEED/SLOW;
	            break;
	        case DIRECTION_RIGHT:
	        	if(position.x < 700)
	        		position.x += SPEED/SLOW;
	            break;
	        case DIRECTION_DOWN:
	        	if(position.y > 0)
	        		position.y -= SPEED/SLOW;
	            break;
	        case DIRECTION_LEFT:
	        	if(position.x > 0)
	            	position.x -= SPEED/SLOW;
	            break;
	        }
	    }

}
