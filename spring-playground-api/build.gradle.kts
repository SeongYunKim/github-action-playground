tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

apply(plugin = "com.google.cloud.tools.jib")

dependencies {
    implementation(project(":spring-playground-common"))
    implementation(project(":spring-playground-jpa"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}
