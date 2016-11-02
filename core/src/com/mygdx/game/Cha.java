package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Cha extends GameObject
{
	public Cha(int x, int y)
	{
		super(x, y);
	}

	public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_STILL = 0;
    public static final int SPEED = 10;
    public static int LIFE = 3;
    
	 public void move(int dir) 
	 { 
	        switch(dir) {
	        case DIRECTION_UP:
	            position.y += SPEED;
	            break;
	        case DIRECTION_RIGHT:
	            position.x += SPEED;
	            break;
	        case DIRECTION_DOWN:
	            position.y -= SPEED;
	            break;
	        case DIRECTION_LEFT:
	            position.x -= SPEED;
	            break;
	        }
	    }

}
