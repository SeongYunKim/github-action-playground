import com.google.cloud.tools.jib.gradle.JibExtension

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

configure<JibExtension> {
    from {
        image = "eclipse-temurin:17-jre"
    }

    to {
        image = "abc/abc"
        tags = setOf("latest")
    }

    container {
        mainClass = "com.seongyunkim.api.SpringPlaygroundApiKt"
        ports = listOf("8080")
        environment = mapOf(
            "TZ" to "Asia/Seoul",
        )
        jvmFlags = listOf(
            "-Xms512m", "-Xmx512m",
        )
    }
}
