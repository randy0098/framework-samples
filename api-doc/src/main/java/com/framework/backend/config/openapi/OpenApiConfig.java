package com.framework.backend.config.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * 默认前端页面地址为：http://ip:port/swagger-ui.html <br>
 * 默认后端api的json地址为：http://ip:port/v3/api-docs
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "API", version = "1.0", description = "API v1.0"))
public class OpenApiConfig {}
