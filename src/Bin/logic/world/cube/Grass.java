/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic.world.cube;

import Bin.graphic.Texture;
import org.joml.Matrix4f;

public class Grass extends Cube {
    private static final Texture texture = new Texture("grassblock");
    public Grass() {
        super();
    }
    public void render(Matrix4f cameraMatrix) {
        super.render(texture, cameraMatrix);
    }
}
