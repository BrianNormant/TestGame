/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.logic;

import Bin.graphic.Window;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFWKeyCallbackI;

import static org.lwjgl.glfw.GLFW.*;

public class Control {
    public static final float DISPLACEMENT_SENSITIVITY = 0.1f;
    private static final float ROTATION_SENSITIVITY = 0.5f;

    public static GLFWKeyCallbackI windowControl = (window, key, scancode, action, mods) -> {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) glfwSetWindowShouldClose(window, true);
    };
    public static void player(Player player, Mouse mouse, Window keyboard) {
        Vector3f positionOffset = new Vector3f(0);
        Vector3f rotationOffset = new Vector3f(0);
        if (keyboard.isKeyPressed(GLFW_KEY_S)) {
            positionOffset.z += DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_W)) {
            positionOffset.z -= DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_SPACE)) {
            positionOffset.y += DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            positionOffset.y -= DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_A)) {
            positionOffset.x -= DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_D)) {
            positionOffset.x += DISPLACEMENT_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_Q)) {
            rotationOffset.z += ROTATION_SENSITIVITY;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_E)) {
            rotationOffset.z -= ROTATION_SENSITIVITY;
        }

        player.displace(positionOffset);
    }
    public static void camera(Camera camera, Mouse mouse, Window keyboard) {
        mouse.input();
        if (mouse.isLeftButtonPressed()) {
            Vector2f temp = mouse.getDisplVec();
            temp.y *= ROTATION_SENSITIVITY;
            temp.x *= ROTATION_SENSITIVITY;
            camera.addRotation(temp);
        } else if (keyboard.isKeyPressed(GLFW_KEY_K)) camera.setRotation(new Vector3f(0,0,0));
    }
}
