/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    Vector3f position, rotation;
    Matrix4f cameraMatrix = new Matrix4f().identity();

    public Camera() {
        rotation = new Vector3f(0,0,0);
        position = new Vector3f(0);
    }

    public void updateCamera(Player player) {
        position = player.getPosition();
        cameraMatrix = new Matrix4f().identity();
        cameraMatrix.rotate(
                (float) Math.toRadians(rotation.x), new Vector3f(1,0,0)).rotate(
                (float) Math.toRadians(rotation.y), new Vector3f(0,1,0)).rotate(
                (float) Math.toRadians(rotation.z), new Vector3f(0,0,1));
        cameraMatrix.translate( -position.x, -position.y, -position.z);
    }

    public Matrix4f getCameraMatrix() {
        return cameraMatrix;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
    public void addRotation(Vector2f temp) {
        rotation.x += temp.x;
        rotation.y += temp.y;
    }
}
