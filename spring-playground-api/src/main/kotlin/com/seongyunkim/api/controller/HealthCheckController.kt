package com.seongyunkim.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1/healthcheck")
@RestController
class HealthCheckController() {
    @GetMapping
    fun healthCheck(): String {
        return "success"
    }
}
