import com.google.cloud.tools.jib.gradle.JibExtension
import org.ajoberstar.grgit.Grgit

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

apply(plugin = "com.google.cloud.tools.jib")
apply(plugin = "org.ajoberstar.grgit")

dependencies {
    implementation(project(":spring-playground-common"))
    implementation(project(":spring-playground-jpa"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}

configure<JibExtension> {
    val git = Grgit.open { dir = rootDir }
    val commitHashId = git.head().abbreviatedId
    val registryRepository = findProperty("registryRepository")

    from {
        image = "eclipse-temurin:17-jre"
    }

    to {
        image = registryRepository as String
        tags = setOf(commitHashId)
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
