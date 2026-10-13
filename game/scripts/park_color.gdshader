shader_type canvas_item;
uniform float saturation = 1.0;
uniform float warmth = 0.0;
void fragment() {
	vec4 source = COLOR;
	float luma = dot(source.rgb, vec3(0.2126, 0.7152, 0.0722));
	vec3 graded = mix(vec3(luma), source.rgb, saturation);
	graded *= vec3(1.0 + warmth * 0.4, 1.0 + warmth * 0.08, 1.0 - warmth);
	COLOR = vec4(clamp(graded, vec3(0.0), vec3(1.0)), source.a);
}
