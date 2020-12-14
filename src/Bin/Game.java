/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin;

import engine.Camera;
import engine.Cube;
import engine.Item;
import engine.Mouse;
import engine.graphic.Texture;
import engine.graphic.Window;

public class Game {
    private final Window window;
    private final Mouse mouse;
    private final Camera camera;

    Game() {
        window = new Window(720, 480, "Game Test");
        mouse = new Mouse(window);
        camera = new Camera();
    }

    void launch() {
        Cube cube = new Cube(new Texture("diamond"));
        window.setRenderInstruction(() -> {
            cube.render(camera.getViewMatrix());
            Item.renderAll(camera.getViewMatrix());
        });

        window.render(camera, mouse);
    }

    public Window getWindow() {
        return window;
    }

}