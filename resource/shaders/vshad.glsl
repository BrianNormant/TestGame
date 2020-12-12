#version 330 core
layout (location = 0) in vec3 position;
layout (location = 1) in vec2 aTextCoord;
out vec2 textCoord;
uniform mat4 projection;
uniform mat4 modelView;
void main() {
    gl_Position = projection*modelView*vec4(position, 1.0f);
    textCoord = aTextCoord;
}
