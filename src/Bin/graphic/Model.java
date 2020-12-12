/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin.graphic;

import Bin.lwjgl.Buffer;
import Bin.lwjgl.ShaderProgram;
import Bin.lwjgl.VertexArray;
import org.joml.Matrix4f;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

public class Model {
    private final VertexArray VAO;
    private final Buffer indices, vertices, texture;
    private final int length;
    public Model(float[] vertices, int[] indices, float[] texture) {
        length = indices.length;
        this.indices = new Buffer(GL_ELEMENT_ARRAY_BUFFER, 3);
        this.vertices = new Buffer(GL_ARRAY_BUFFER, 3);
        this.texture = new Buffer(GL_ARRAY_BUFFER, 2);

        this.indices.bufferData(indices);
        this.vertices.bufferData(vertices);
        this.texture.bufferData(texture);

        this.VAO = new VertexArray(this.indices, this.vertices, this.texture);
    }
    public void render(ShaderProgram shader,Texture texture, Matrix4f cameraMatrix, Matrix4f modelViewMatrix) {
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, texture.id);
        shader.use(new Object[]{cameraMatrix, modelViewMatrix, 0});

        VAO.use(length);

        glDrawElements(GL_TRIANGLES,length,GL_UNSIGNED_INT,0);
        glBindVertexArray(0);
    }
    public void render(ShaderProgram shader, Texture texture, Matrix4f projectionMatrix) {
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, texture.id);

        shader.use(new Object[]{projectionMatrix, 0});

        VAO.use(length);
    }
    public void destroy() {
        this.indices.delete();
        this.vertices.delete();
        this.texture.delete();
        VAO.delete();
    }
}
