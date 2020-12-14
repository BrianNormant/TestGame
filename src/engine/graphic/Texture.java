/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine.graphic;

import de.matthiasmann.twl.utils.PNGDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static Bin.Main.resourceRoot;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

public class Texture {
    private PNGDecoder decoder;
    public ByteBuffer data;
    int id;
    public Texture(String fileName) {
        try {
            decoder = new PNGDecoder(
                    new FileInputStream(
                            new File(resourceRoot+"textures\\"+fileName+".png")
                    )
            );
            data = ByteBuffer.allocateDirect(4*decoder.getWidth()*decoder.getHeight());
            try {
                decoder.decode(data, 4*decoder.getWidth(), PNGDecoder.Format.RGBA);
                data.flip();
                genTexture();
            } catch (Exception exception) {
                System.out.println("Wrong File for "+ fileName);
            }
        } catch (IOException exception) {
            System.out.println("Texture not found at + "+ fileName);
        }
    }

    public void genTexture() {
        id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);
        glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, decoder.getWidth(), decoder.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
        glGenerateMipmap(GL_TEXTURE_2D);
    }
    public void use() {
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, this.id);
    }
    public void endUse() {
        glBindTexture(GL_TEXTURE_2D,0);
        glActiveTexture(0);
    }
}
