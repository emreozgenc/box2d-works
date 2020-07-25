package com.emreozgenc.box2dworks;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Box2DWorks extends Game {

	public OrthographicCamera cam;

	@Override
	public void create() {
		cam = new OrthographicCamera();

		// Here we are setting our camera
		cam.setToOrtho(false, Constants.V_WIDTH, Constants.V_HEIGHT);
		cam.update();
	}
}
