/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic.world.cube;

import Bin.graphic.Coords;
import Bin.graphic.Model;
import Bin.graphic.Texture;
import Bin.logic.world.GameItem;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Cube extends GameItem {
    static final Model cubeModel = new Model(Coords.cubeVertices, Coords.cubeIndices, Coords.cubeTexture);
    Vector3f position,rotation;
    float scale;
    public Cube() {
        super(cubeModel);
        defaultValue();
    }
    public Cube(Model model) {
        super(model);
        defaultValue();
    }
    private void defaultValue() {
        position = new Vector3f(0,0,0);
        rotation = new Vector3f(0,0,0);
        scale = 1.0f;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }

     Matrix4f getModelViewMatrix(Matrix4f viewMatrix) {
        Matrix4f transformationMatrix = new Matrix4f().identity()
                .translate(position).
                        rotateX((float)Math.toRadians(-rotation.x)).
                        rotateY((float)Math.toRadians(-rotation.y)).
                        rotateZ((float)Math.toRadians(-rotation.z)).
                        scale(this.scale);

        return transformationMatrix.mul(viewMatrix);
    }
    public void render(Texture texture, Matrix4f viewMatrix) {
        super.render(texture, getModelViewMatrix(viewMatrix));
    }
}
