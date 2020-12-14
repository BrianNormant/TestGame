/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine;

import engine.graphic.Model;
import engine.graphic.Texture;
import org.joml.Vector3f;

import static engine.graphic.Coords.*;

public class Cube extends Item {
    private static final Model model = new Model(cubeIndices, cubeVertices, cubeTexture);
    public Cube(Texture texture) {
        this(texture,new Vector3f(0), new Vector3f(0));
    }
    public Cube(Texture texture, Vector3f position, Vector3f rotation) {
        super(model, texture, new Vector3f(position), new Vector3f(rotation));
    }
}
