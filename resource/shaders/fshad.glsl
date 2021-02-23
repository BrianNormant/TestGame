#version 330 core
in vec2 textCoord;
in vec3 normal;
in vec3 fragPos;
out vec4 fragColor;

uniform sampler2D texture;
uniform vec4 ambientLight;
uniform vec3 lightPos;

void main() {
    vec3 ambient = ambientLight.w * ambientLight.xyz;
    vec3 norm = normalize(normal);
    vec3 lightDir = normalize(lightPos-fragPos);
    float diff = max(dot(norm,lightDir),0);
    vec3 diffuse = diff*ambientLight.xyz;
    fragColor = vec4(ambient+diffuse, 1) * texture2D(texture, textCoord);
}