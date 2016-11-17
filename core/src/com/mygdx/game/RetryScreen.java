package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RetryScreen extends ScreenAdapter {

	ProjectGame projectGame;
	World world;
	WorldRenderer worldrenderer;
	int state;
	public RetryScreen(ProjectGame projectGame,int state) {
		this.projectGame = projectGame;
		this.state = state;
		world = new World(projectGame);
		worldrenderer = new WorldRenderer(projectGame.batch, world, projectGame.showScore);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(255, 255, 255, 255);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    if(state == 1)
	    	worldrenderer.renderRetryScreen();
	    if(state == 2)
	    	worldrenderer.renderWInScreen();
	    if(Gdx.input.isKeyPressed(Keys.ENTER)){
	    	World.score = 0;
	    	projectGame.setScreen(new GameScreen(projectGame));	
	    }
	    
	}
}