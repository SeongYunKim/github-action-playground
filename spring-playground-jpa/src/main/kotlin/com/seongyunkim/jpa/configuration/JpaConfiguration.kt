package com.seongyunkim.jpa.configuration

import com.seongyunkim.jpa.JpaModule
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@Configuration
@EntityScan(basePackageClasses = [JpaModule::class])
@EnableJpaRepositories(basePackageClasses = [JpaModule::class])
class JpaConfig
