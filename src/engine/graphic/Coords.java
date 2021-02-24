/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine.graphic;

public class
Coords {
    public static final int[] squareIndices = new int[]{
            0,1,2,
            1,2,3
    };
    public static final float[] squareVertices = new float[]{
            -1,1,0,
            1,1,0,
            -1,-1,0,
            1,-1,0
    };
    public static final float[] squareTexture = new float[]{
            -1,1,0,
            1,1,0,
            -1,-1,0,
            1,1,0,
            -1,-1,0,
            1,-1,0
    };
    public static final int[] cubeIndices = new int[]{
            // Back face
            0, 1, 2, 3, 4, 5,
            // Front face
            6, 7, 8, 9, 10, 11,
            // Right face
            12, 13, 14, 15, 16, 17,
            // Left face
            18, 19, 20, 21, 22, 23,
            // Bottom face
            24, 25, 26, 27, 28, 29,
            // Top face
            30, 31, 32, 33, 34, 35,
    };
    public static final float[] cubeVertices = new float[]{
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            -0.5f, 0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,

            -0.5f, -0.5f, 0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, 0.5f,
            -0.5f, -0.5f, 0.5f,

            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f, 0.5f,
            -0.5f, 0.5f, 0.5f,

            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,

            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, -0.5f,

            -0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
    };
    public static final float[] cubeTexture = new float[]{
            0.25f, 1.0f,//top left
            0.00f, 1.0f,//top right
            0.00f, 0.5f,//bottom right
            0.00f, 0.5f,//bottom right
            0.25f, 0.5f,//bottom left
            0.25f, 1.0f,//top left

            0.00f, 1.0f-0.5f,//top left
            0.25f, 1.0f-0.5f,//top right
            0.25f, 0.5f-0.5f,//bottom right
            0.25f, 0.5f-0.5f,//bottom right
            0.00f, 0.5f-0.5f,//bottom left
            0.00f, 1.0f-0.5f,//top left

            /*0*/1.00f,  0.0f,//top left
            /*1*/0.75f,  0.0f,//top right
            /*2*/0.75f,  0.5f,//bottom right
            /*3*/0.75f,  0.5f,//bottom right
            /*4*/1.00f,  0.5f,//bottom left
            /*5*/1.00f,  0.0f,//top left

            /*0*/0.75f-0.25f,  0.0f,//top left
            /*1*/1.00f-0.25f,  0.0f,//top right
            /*2*/1.00f-0.25f,  0.5f,//bottom right
            /*3*/1.00f-0.25f,  0.5f,//bottom right
            /*4*/0.75f-0.25f,  0.5f,//bottom left
            /*5*/0.75f-0.25f,  0.0f,//top left

            0.25f,  0.5f+0.5f,
            0.5f,   0.5f+0.5f,
            0.5f,   0.0f+0.5f,
            0.5f,   0.0f+0.5f,
            0.25f,  0.0f+0.5f,
            0.25f,  0.5f+0.5f,

            0.25f,  0.5f,
            0.5f,   0.5f,
            0.5f,   0.0f,
            0.5f,   0.0f,
            0.25f,  0.0f,
            0.25f,  0.5f,
    };
    public static final float[] cubeNormals = new float[]{
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, -1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            -1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, -1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
    };

    //TODO circle
    //TODO sphere
}
