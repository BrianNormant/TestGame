/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package Bin;

import Bin.math.Matrix;
import org.joml.Matrix4f;

public class Main {
    public static final String resourceRoot = "C:\\Users\\brian.GAKCALCULATEUR\\Desktop\\IDEA workspace\\Test Game\\resource\\";
    public static final Matrix4f projectionMatrix = new Matrix4f().perspective(60,0.5f,0.01f,1000);
    public static void main(String[] args) {
        Matrix<Integer> mat = new Matrix<>(4,4);
        mat.fill(6);
        System.out.println(mat);
        Game instance = new Game();
        instance.launch();
    }
}
