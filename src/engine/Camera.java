/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class Camera {
    Vector3f position, rotation;
    public Camera() {
        rotation = new Vector3f(0,0,0);
        position = new Vector3f(0);
    }

    public Matrix4f getViewMatrix() {
        Matrix4f viewMatrix = new Matrix4f().identity();
        viewMatrix.rotate(
                (float) Math.toRadians(rotation.x), new Vector3f(1,0,0)).rotate(
                (float) Math.toRadians(rotation.y), new Vector3f(0,1,0)).rotate(
                (float) Math.toRadians(rotation.z), new Vector3f(0,0,1));
        viewMatrix.translate( -position.x, -position.y, -position.z);
        return viewMatrix;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
    public void addRotation(Vector2f temp) {
        rotation.x += temp.x;
        rotation.y += temp.y;
    }
    public void setPosition(Vector3f position) {
        this.position = position;
    }
    public void addPosition(Vector3f position) {
        this.position.x += (float)Math.sin(Math.toRadians(rotation.y)) * -1.0f * position.z;
        this.position.x += (float)Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * position.x;
        this.position.y += position.y;
        this.position.z += (float)Math.cos(Math.toRadians(rotation.y)) * position.z;
        this.position.z += (float)Math.cos(Math.toRadians(rotation.y - 90)) * position.x;
    }

    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getRotation() {
        return rotation;
    }
}
