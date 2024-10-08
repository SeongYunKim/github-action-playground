package com.seongyunkim.api.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZonedDateTime

@RequestMapping("/api/v1/healthcheck")
@RestController
class HealthCheckController(
    private val environment: Environment,
) {
    @GetMapping
    fun healthCheck(): String {
        return "${environment.activeProfiles.first()}_${ZonedDateTime.now()}"
    }
}
