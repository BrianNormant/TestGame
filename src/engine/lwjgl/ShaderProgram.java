/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine.lwjgl;

import Bin.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {
    private final int id;
    private final Shader vertex, fragment;
    private final ArrayList<Uniform> uniforms = new ArrayList<>();
    public ShaderProgram(String vertex, String fragment, String... names) {
        id = glCreateProgram();

        this.vertex = new Shader(GL_VERTEX_SHADER);
        this.fragment = new Shader(GL_FRAGMENT_SHADER);

        this.vertex.setSource(loadFromFile(vertex));
        this.fragment.setSource(loadFromFile(fragment));

        this.vertex.compile();
        this.fragment.compile();

        compile();
        addUniforms(names);
        cleanup();
    }
    private void addShader(Shader shader) {
        glAttachShader(getId(), shader.getId());
    }
    private void compile() {
        addShader(this.vertex);
        addShader(this.fragment);

        glLinkProgram(getId());

        if (glGetProgrami(getId(), GL_LINK_STATUS) == GL_FALSE) System.out.println(glGetProgramInfoLog(getId()));
    }
    private void cleanup() {
        this.vertex.delete();
        this.fragment.delete();
    }
    private void addUniforms(String... names) {
        for (String name : names) {
            Uniform u = new Uniform(name);
            u.setId(glGetUniformLocation(getId(), name));
            uniforms.add(u);
        }
    }
    public void use(Object[] uniformsData) {
        glUseProgram(getId());
        for (int i = 0; i < uniforms.size(); i++) {
            uniforms.get(i).setValue(uniformsData[i]);
        }
    }

    public int getId() {
        return id;
    }

    private static String loadFromFile(String name) {//!name without extension file
        File file = new File(Main.resourceRoot+"shaders\\"+name+".glsl");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder source = new StringBuilder();
        if (scanner == null)throw new IllegalStateException("");
        while(scanner.hasNextLine()) {
            source.append(scanner.nextLine()).append("\n");
        }
        source.append("\0");
        return source.toString();
    }
    static class Shader {
        private final int type;
        private final int id;
        public Shader(int type) {
            this.type = type;
            id = glCreateShader(getType());
        }
        public void setSource(String source) {
            glShaderSource(getId(), source);
        }
        public void compile() {
            glCompileShader(getId());

            if (glGetShaderi(getId(), GL_COMPILE_STATUS) == GL_FALSE) System.out.println(glGetShaderInfoLog(getId(), GL_COMPILE_STATUS));
        }
        public void delete() {
            glDeleteShader(getId());

            if (glGetShaderi(getId(), GL_DELETE_STATUS) == GL_FALSE) System.out.println("Failed to delete shader");
        }
        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }
    }
}