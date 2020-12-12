/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin;

import Bin.graphic.RenderInstruction;
import Bin.graphic.Window;
import Bin.logic.Mouse;
import Bin.logic.Player;
import Bin.logic.world.World;
import Bin.logic.world.cube.Grass;

import java.util.Scanner;

public class Game {
    private final Window window;
    private final Player player;
    private final Mouse mouse;
    private final World world;

    Game() {
        window = new Window(720, 480, "Game Test");
        mouse = new Mouse(window);
        player = new Player(Main.resourceRoot);
        world = new World(5);
    }

    void launch() {
        Grass g = new Grass();

        window.setRenderInstruction(() -> {
            world.compute(player.getCamera().getCameraMatrix());
        });

        window.render(player, mouse);
    }

    public Window getWindow() {
        return window;
    }

}