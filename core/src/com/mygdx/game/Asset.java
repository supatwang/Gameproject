package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Asset {
	
	public static Texture ChaImg;
	public static Texture BulletImg;
	public static Texture Enemy1;

	public static void load() {
		ChaImg = new Texture("Cha.png");
		BulletImg = new Texture("bullet_blue.png");
		Enemy1 = new Texture("Cha.png");
	}

}
