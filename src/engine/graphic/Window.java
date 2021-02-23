package engine.graphic;

import engine.Camera;
import Bin.Control;
import engine.Mouse;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static java.sql.Types.NULL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;

public class Window {

    //Property
    public final long id;
    public int width, height;
    public String label;
    private final float fieldOfView = 60f, zNear = 0.0001f, zFar = 1000f;
    Matrix4f projectionMatrix;
    private RenderInstruction instruction;

    //Constructor
    public Window(int width, int height, String label) {
        GLFWErrorCallback.createPrint(System.err).set();

        if(!org.lwjgl.glfw.GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        this.width = width;
        this.height = height;
        this.label = label;
        id = glfwCreateWindow(width, height, label, NULL, NULL);

        try(MemoryStack stack = stackPush()){
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            GLFW.glfwGetWindowSize(this.id, pWidth, pHeight);

            GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

            GLFW.glfwSetWindowPos(this.id,(vidmode.width() - pWidth.get(0)) / 2,(vidmode.height() - pHeight.get(0)) / 2);

            GLFW.glfwMakeContextCurrent(this.id);
            GLFW.glfwSwapInterval(1);
            GLFW.glfwShowWindow(this.id);
        }
        glfwSetFramebufferSizeCallback(id, (window, w, h)-> {
            glViewport(0,0, w, h);
            this.width = w; this.height = h;
            updateProjectionMatrix();
        });
        updateProjectionMatrix();
        GL.createCapabilities();
        glfwSetKeyCallback(id, Control.windowControl);
        glEnable(GL_DEPTH_TEST);
    }
    //Methods
    private void updateProjectionMatrix() {
        float aspectRatio = width/(float)height;
        projectionMatrix = new Matrix4f().perspective((float) Math.toRadians(fieldOfView), aspectRatio, zNear, zFar);
        Bin.Main.projectionMatrix = this.projectionMatrix;
    }

    public boolean isKeyPressed(int key) {
        return glfwGetKey(id, key) == GLFW_PRESS;
    }
    public void render(Camera camera, Mouse mouse) {
        while (!glfwWindowShouldClose(this.id)) {
            glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);

            instruction.render();

            glfwSwapBuffers(id);
            glfwPollEvents();
            Control.camera(camera, mouse, this);
            Control.player(camera, this);
        }
    }
    //Getters
    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    //Setters

    public void setRenderInstruction(RenderInstruction instruction) {
        this.instruction = instruction;
    }
}
