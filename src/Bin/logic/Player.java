/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic;

import Bin.logic.inventory.Hotbar;
import org.joml.Vector3f;

public class Player {
    Vector3f position, rotation;
    Camera camera;
    public Hotbar hotbar;
    public Player(String repository) {
        hotbar = new Hotbar();
        position = new Vector3f(0,0,0);
        rotation = position;
        camera = new Camera();
    }
    private void updatePlayer() {
        rotation = camera.rotation;
        camera.updateCamera(this);
    }
    public void move(Vector3f newPosition) {
        position = newPosition;
        updatePlayer();
    }
    public void displace(Vector3f position) {
        this.position.x += (float)Math.sin(Math.toRadians(camera.rotation.y)) * -1.0f * position.z + (float)Math.sin(Math.toRadians(camera.rotation.y-90)) * -1.0f * position.x;
        this.position.y += position.y;
        this.position.z += (float)Math.sin(Math.toRadians(camera.rotation.y)) * position.z + (float)Math.sin(Math.toRadians(camera.rotation.y-90)) * position.x;
        updatePlayer();
    }
    public Vector3f getPosition() {
        return this.position;
    }

    public Vector3f getRotation() {
        return this.rotation;
    }

    public Camera getCamera() {
        return this.camera;
    }
}
