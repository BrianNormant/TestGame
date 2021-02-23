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
import engine.lwjgl.ShaderProgram;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;

public class Item {
    private static final ArrayList<Item> references = new ArrayList<>();

    public static void renderAll(Matrix4f cameraMatrix) {
        for (Item item : references) item.render(cameraMatrix);
    }
    public static void addNew(Vector3f position) {
        Vector3f pos = new Vector3f(position);
        pos.x = (int)position.x;
        pos.y = (int)position.y;
        pos.z = (int)position.z;
        for (Item item : references)
            if (item.position.equals(pos)) return;
        references.add(
                new Cube(new Texture("grassblock"), pos, new Vector3f(0))
        );
    }

    private boolean show = true;
    private Model model;
    private Texture texture;
    private Vector3f position, rotation;
    private float scale;

    private static final ShaderProgram shader = new ShaderProgram("vshad", "fshad", "camera","projection","model","texture","ambientLight");
    public static void delete(int id) {
        if (references.size() > 0)
            references.get(references.size() - 1).delete();
    }
    {
        references.add(this);
    }
    public Item(Model model, Texture texture) {
        this(model, texture, new Vector3f(), new Vector3f());
    }
    public Item(Model model, Texture texture, Vector3f position, Vector3f rotation) {
        this(model, texture, position, rotation, 1);
    }
    Item(Model model, Texture texture, Vector3f position, Vector3f rotation, float scale) {
        this.model = model;
        this.texture = texture;
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }
    Matrix4f getModelMatrix() {
        Vector3f rotation = this.rotation;
        return new Matrix4f().identity().translate(this.position).
                rotateX((float)Math.toRadians(-rotation.x)).
                rotateY((float)Math.toRadians(-rotation.y)).
                rotateZ((float)Math.toRadians(-rotation.z)).
                scale(this.scale);
    }
    public void move(Vector3f offset) {
        this.position.x += offset.x;
        this.position.y += offset.y;
        this.position.z += position.z;
    }
    public void setPosition(Vector3f position) {
        this.position = position;
    }
    public void addRotation(Vector3f offset) {
        this.rotation.x += offset.x;
        this.rotation.y += offset.y;
        this.rotation.z += offset.z;
    }
    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
    public void changeModel(Model model) {
        this.model = model;
    }
    public void render(Matrix4f cameraMatrix) {
        if (!show) return;
        model.render(shader, texture, cameraMatrix, getModelMatrix());
    }
    public void delete() {
        references.remove(this);
        this.model = null;
        this.position = null;
        this.rotation = null;
        this.texture = null;
        this.show = false;
    }
}
