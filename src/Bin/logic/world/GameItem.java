/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic.world;

import Bin.graphic.Model;
import Bin.graphic.Texture;
import Bin.lwjgl.ShaderProgram;
import org.joml.Matrix4f;

public class GameItem {
    private Model model;
    private static final ShaderProgram shader = new ShaderProgram("vshad", "fshad", new String[]{"camera","modelView","texture"});
    public GameItem(Model model) {
        this.model = model;
    }
    public void changeModel(Model model) {
        this.model = model;
    }
    public void render(Texture texture, Matrix4f modelViewMatrix, Matrix4f cameraMatrix) {
        model.render(shader, texture, cameraMatrix, modelViewMatrix);
    }
}
