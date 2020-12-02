/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic.inventory;

import Bin.graphic.Coords;
import Bin.graphic.Model;
import Bin.lwjgl.ShaderProgram;
import Bin.graphic.Texture;
import org.joml.Matrix4f;

public class Hotbar {
    private static final ShaderProgram shader = new ShaderProgram("inventoryVertex","inventoryFragment", new String[]{"projection","texture"});
    final Model model;
    final Texture texture;
    public Hotbar() {
        texture = new Texture("hotbar");
        model = new Model(Coords.squareVertices, Coords.squareIndices, Coords.squareTexture);
    }
    public void render(Matrix4f projectionMatrix) {
        model.render(shader ,texture, projectionMatrix);
    }
}
