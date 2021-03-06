package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Asset {
	
	public static Texture ChaImg;
	public static Texture ChaHurtImg;
	public static Texture BulletImg;
	public static Texture Enemy1;
	public static Texture BgImg;
	public static Texture EnemyBullet;
	public static Texture bobo;
	public static Texture tryAgain;
	public static Texture winScreen;

	public static void load() {
		ChaImg = new Texture("Cha.png");
		BulletImg = new Texture("bullet_blue.png");
		Enemy1 = new Texture("Enemy.png");
		EnemyBullet = new Texture("EBullet.png");
		BgImg = new Texture("bg.png");
		ChaHurtImg = new Texture("ChaHurt.png");
		bobo = new Texture("bobo.png");
		tryAgain = new Texture("tryagain.png");
		winScreen = new Texture("winScreen.png");
	}

}
