/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.lwjgl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.*;

public class VertexArray {
    //propriete
    private final int id;
    private int pointer = 0;

    //constructeur
    {
        id = glGenVertexArrays();
    }
    public VertexArray() {}
    public VertexArray(Buffer indices, Buffer vertices) {
        addBuffer(indices);
        addBuffer(vertices);
    }
    public VertexArray(Buffer indices, Buffer vertices, Buffer texture) {
        addBuffer(indices);
        addBuffer(vertices);
        addBuffer(texture);
    }
    //methods
    private void addLocate(int coordSize) {
        glVertexAttribPointer(pointer, coordSize, GL_FLOAT, false, 0, 0);
        pointer++;
    }

    public void addBuffer(Buffer buffer) {
        glBindVertexArray(getId());
        glBindBuffer(buffer.getType(), buffer.getId());

        if (buffer.getType() == GL_ARRAY_BUFFER) addLocate(buffer.getCoordSize());

        glBindVertexArray(0);
        glBindBuffer(buffer.getType(), 0);
    }

    public void use(int length) {
        glBindVertexArray(getId());
        for (int i = 0; i < pointer+1; i++) glEnableVertexAttribArray(i);
        glDrawElements(GL_TRIANGLES, length, GL_UNSIGNED_INT, 0);
        glBindVertexArray(0);
    }

    public void delete() {
        glDeleteVertexArrays(getId());
    }

    //getters
    public int getId() {
        return id;
    }
    //setters

}
