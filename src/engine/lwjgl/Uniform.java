/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine.lwjgl;

import org.joml.Matrix2f;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

public class Uniform {
    private final String name;
    private int id;

    public Uniform(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public void setValue(Object value) {
        if (value instanceof Float) {
            glUniform1f(getId(), (float) value);
        } else if ( value instanceof Matrix4f ) {
            glUniformMatrix4fv(getId(), false, toBuffer((Matrix4f) value));
        } else if ( value instanceof Integer ) {
            glUniform1f(getId(), (int)value);
        }
    }
    public static FloatBuffer toBuffer(Matrix4f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            return matrix.get(stack.mallocFloat(16));
        }
    }
    public static FloatBuffer toBuffer(Matrix3f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            return matrix.get(stack.mallocFloat(9));
        }
    }
    public static FloatBuffer toBuffer(Matrix2f matrix) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            return matrix.get(stack.mallocFloat(4));
        }
    }
}
