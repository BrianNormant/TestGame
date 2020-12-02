/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.lwjgl;

import static org.lwjgl.opengl.GL15.*;

public class Buffer {
    private final int id;
    private final int type;
    private final int coordSize;
    public Buffer(int type, int coordSize) {
        id = glGenBuffers();
        this.type = type;
        this.coordSize = coordSize;
    }

    public void bufferData(int[] data) {
        glBindBuffer(getType(), getId());
        glBufferData(getType(), data, GL_STATIC_DRAW);
        glBindBuffer(getType(), 0);
    }
    public void bufferData(float[] data) {
        glBindBuffer(getType(), getId());
        glBufferData(getType(), data, GL_STATIC_DRAW);
        glBindBuffer(getType(), 0);
    }
    public void delete() {
        glDeleteBuffers(getId());
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getCoordSize() {
        return coordSize;
    }
}
