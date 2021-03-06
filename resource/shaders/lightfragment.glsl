#version 330 core
in vec2 textCoord;
out vec4 fragColor;

uniform sampler2D texture;

void main() {
    fragColor = texture2D(texture, textCoord);
}