#version 330 core
out vec4 fragColor;
in vec2 textCoord;

uniform sampler2D texture;
void main() {
    //fragColor = texture(texture, textCoord);
    fragColor = vec4(1,0,0,1);
}
