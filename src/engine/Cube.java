/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine;

import bin.Main;
import engine.graphic.Model;
import engine.graphic.ShaderUses;
import engine.graphic.Texture;
import org.joml.Vector3f;
import org.joml.Vector4f;

import static engine.graphic.Coords.*;

public class Cube extends Item {
    private static final Model model = new Model(cubeIndices, cubeVertices, cubeTexture, cubeNormals);
    public static final ShaderUses uses = ((shader, uniformsData) -> shader.use(new Object[]{
            //Vertex Shader
            uniformsData[0],//camera
            Main.projectionMatrix,//projection
            uniformsData[1], //model
            //Fragment Shader
            0,//texture
            new Vector4f(Light.ambientLight, Light.ambientStrength),//lightColor
            Light.REFERENCES.get(0).place.position,//lightPos
            Light.REFERENCES.get(0).color//lightColor
    }));
    public Cube(Texture texture) {
        this(texture,new Vector3f(0), new Vector3f(0));
    }
    public Cube(Texture texture, ShaderUses uses) {
        this(texture, new Vector3f(0), new Vector3f(0), uses);
    }
    public Cube(Texture texture, Vector3f position, Vector3f rotation) {
        super(model, texture, new Vector3f(position), new Vector3f(rotation), uses);
    }
    public Cube(Texture texture, Vector3f position, Vector3f rotation, ShaderUses uses) {
        super(model, texture, new Vector3f(position), new Vector3f(rotation), uses);
    }
}
