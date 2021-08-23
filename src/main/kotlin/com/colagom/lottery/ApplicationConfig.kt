package com.colagom.lottery

import org.modelmapper.ModelMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate


@Configuration
class ApplicationConfig {

    @Bean
    fun beanModelMapper() = ModelMapper()

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder
        .build().apply {
            messageConverters.add(
                MappingJackson2HttpMessageConverter().apply {
                    supportedMediaTypes = listOf(MediaType.ALL)
                }
            )
        }
}