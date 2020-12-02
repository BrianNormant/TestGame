/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin;

import Bin.graphic.Window;
import Bin.logic.Mouse;
import Bin.logic.Player;
import Bin.logic.world.World;
import Bin.logic.world.cube.Grass;

import java.util.Scanner;

public class Game implements Runnable {
    private final Window window;
    private final Player player;
    private final Mouse mouse;
    private final World world;

    Game() {
        window = new Window(720,480,"Game Test");
        mouse = new Mouse(window);
        player = new Player(Main.resourceRoot);
        world = new World(5);
    }
    void launch() {
        Grass g = new Grass();
        while (window.keepOn) {
            window.preRender();

            g.render(player.getCamera().getCameraMatrix());
            player.hotbar.render(window.getProjectionMatrix());
            //world.compute(player.getCamera().getCameraMatrix());
            window.postRender(player, mouse);
        }
    }

    public Window getWindow() {
        return window;
    }

    @Override
    public void run() {
        boolean isRunning =true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test");
        int i = 0;
        do {
            System.out.print("in["+i+"] ");
            String instruction = scanner.next();
            System.out.println("out["+i+"] "+instruction);
            switch (instruction) {
                case "close" -> {
                    window.keepOn = false;
                    isRunning = false;
                }
            }
            i++;
        } while (isRunning);
    }
}