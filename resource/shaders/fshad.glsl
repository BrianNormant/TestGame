#version 330 core
in vec2 textCoord;
out vec4 fragColor;

uniform sampler2D texture;
uniform vec4 ambientLight;

void main() {
    vec3 ambient = ambientLight.w * ambientLight.xyz;
    fragColor = vec4(ambient, 1) * texture2D(texture, textCoord);
}