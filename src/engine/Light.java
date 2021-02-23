/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine;

import Bin.Main;
import engine.graphic.ShaderUses;
import engine.graphic.Texture;
import engine.lwjgl.ShaderProgram;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Light {
    public static final ShaderProgram lightObjectShader = new ShaderProgram("vshad","lightfragment","camera","projection","model","texture");
    public static final ShaderUses uses = (shader, uniformsData) -> lightObjectShader.use(new Object[]{
            //Vertex Shader
            uniformsData[0],//camera
            Main.projectionMatrix,//projection
            uniformsData[1], //model
            //Fragment Shader
            0,//texture
    });
    public static Vector3f ambientLight = new Vector3f(.8902f,.6627f,.5333f);
    public static float ambientStrength = 0.1f;

    public Item place;
    Vector3f color;
    float intensity;

    {
        place = new Cube(new Texture("sun"), uses);
        color = new Vector3f(1);
        intensity = 1;
    }
    public Light(Vector3f position) {
        this.place.setPosition(position);
    }
    public Light(Vector3f position, Vector3f rotation) {
        this(position);
        this.place.setRotation(rotation);
    }
    public Light(Vector3f position, Vector3f rotation, Vector3f color) {
        this(position, rotation);
        this.color = color;
    }
    public Light(Vector3f position, Vector3f rotation, Vector3f color, float intensity) {
        this(position, rotation, color);
        this.intensity = intensity;
    }
}
