#version 330 core
in vec2 textCoord;
out vec4 fragColor;

uniform sampler2D texture;
void main() {
    //fragColor = texture(texture, textCoord);
    fragColor = vec4(1,0,0,1);
}