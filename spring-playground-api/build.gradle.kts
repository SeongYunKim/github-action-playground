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
    val registryRepository = findProperty("registryRepository") as String?
    val imageTag = findProperty("imageTag") as String? ?: "latest"

    from {
        image = "eclipse-temurin:17-jre"
    }

    to {
        image = registryRepository
        tags = setOf(imageTag)
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
