package Bin.graphic;

import Bin.logic.Control;
import Bin.logic.Mouse;
import Bin.logic.Player;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL;

import static java.sql.Types.NULL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Window {

    public final long id;
    public int width, height;
    public String label;
    private final float fieldOfView = 60f, zNear = 0.0001f, zFar = 1000f;
    Matrix4f projectionMatrix;
    public volatile boolean keepOn = true;

    private void updateProjectionMatrix() {
        float aspectRatio = width/(float)height;
        projectionMatrix = new Matrix4f().perspective(fieldOfView, aspectRatio, zNear, zFar);
    }
    private void setDefaultParameters() {
        glfwInit();
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    }
    private void initOpenGL() {
        glfwMakeContextCurrent(id);
    }
    private void initRender() {
        glfwSetFramebufferSizeCallback(id, (window, w, h)-> {
            glViewport(0,0, w, h);
            this.width = w; this.height = h;
            updateProjectionMatrix();
        });
        updateProjectionMatrix();
        glfwSetKeyCallback(id, Control.windowControl);


        //glfwSwapInterval(1);
        glfwShowWindow(id);
        GL.createCapabilities();
        glClearColor(0.2f,0.5f,0.12f,1);
        glEnable(GL_DEPTH_TEST);
    }

    public Window(int width, int height, String label) {
        setDefaultParameters();
        this.width = width;
        this.height = height;
        this.label = label;
        id = glfwCreateWindow(width, height, label, NULL, NULL);

        initOpenGL();

        initRender();
    }

    public boolean isKeyPressed(int key) {
        return glfwGetKey(id, key)== GLFW_PRESS;
    }
    public void preRender() {
        glClear(GL_COLOR_BUFFER_BIT| GL_DEPTH_BUFFER_BIT);

    }
    public void postRender(Player player, Mouse mouse) {
        glfwSwapBuffers(id);
        glfwPollEvents();
        Control.camera(player.getCamera(), mouse, this);
        Control.player(player, mouse, this);
        keepOn = !glfwWindowShouldClose(id);
    }

    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }
}