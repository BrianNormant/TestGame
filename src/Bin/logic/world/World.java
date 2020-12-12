/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic.world;

import Bin.logic.world.cube.Grass;
import Bin.lwjgl.ShaderProgram;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.ArrayList;

public class World {
    private final ArrayList<GameItem> items = new ArrayList<>();
    ShaderProgram shader;
    public World(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Grass g = new Grass();
                g.setPosition(new Vector3f(i,j,0));
                items.add(g);
            }
        }
    }
    public void compute(Matrix4f viewMatrix) {
        for (GameItem i: items) {
            if (i instanceof Grass) {
                Grass g = (Grass) i;
                g.render(viewMatrix);
            }
        }
    }
}
