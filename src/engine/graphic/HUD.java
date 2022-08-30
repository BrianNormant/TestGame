/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu. Brian Normant 2003 -> Today
 */

package engine.graphic;

import engine.Item;

public class HUD {
    //The HUDcomponent sould be rendered by a separate part after the environment have be drawn
    class HUDcomponent extends Item {

        public HUDcomponent(Model model, Texture texture, ShaderUses uses) {
            super(model, texture, uses);
        }
    }
}
