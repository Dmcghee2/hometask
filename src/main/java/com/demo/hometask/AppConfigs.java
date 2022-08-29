package com.demo.hometask;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfigs {
        private ArrayList<String> configsources = new ArrayList<>();
}
