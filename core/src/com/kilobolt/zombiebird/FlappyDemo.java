package com.kilobolt.zombiebird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.lwjgl.audio.Wav;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kilobolt.zombiebird.States.GameStateManager;
import com.kilobolt.zombiebird.States.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Flappy Bird";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music music;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1); //clear (distroy the screen and recreate - move from render to create
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime()); //get difference between render time
		gsm.render(batch);
	}
}
