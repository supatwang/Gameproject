package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
 
public class GameScreen extends ScreenAdapter {
	ProjectGame projectGame;
	World world;
	WorldRenderer worldrenderer;
	
	public GameScreen(ProjectGame projectGame) {
		this.projectGame = projectGame;
		world = new World(projectGame);
		worldrenderer = new WorldRenderer(projectGame.batch, world,projectGame.showScore);
	}
	
	@Override
	public void render (float delta){
		 world.update();
		 Gdx.gl.glClearColor(0, 0, 0, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         worldrenderer.render();      
	}
}