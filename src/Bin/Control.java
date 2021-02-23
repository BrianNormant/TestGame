/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin;

import engine.Camera;
import engine.Item;
import engine.Mouse;
import engine.graphic.Window;
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
    public static void player(Camera camera, Window keyboard) {
        Vector3f positionOffset = new Vector3f(0);
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

        camera.addPosition(positionOffset);
    }
    public static void camera(Camera camera, Mouse mouse, Window keyboard) {
        mouse.input();

        Vector2f temp = mouse.getDisplVec();
        temp.y *= ROTATION_SENSITIVITY;
        temp.x *= ROTATION_SENSITIVITY;
        camera.addRotation(temp);

        if (keyboard.isKeyPressed(GLFW_KEY_K)) camera.setRotation(new Vector3f(0));
        if (keyboard.isKeyPressed(GLFW_KEY_N)) Item.addNew(camera.getPosition());
        if (keyboard.isKeyPressed(GLFW_KEY_M)) Item.delete(0);
    }
}
