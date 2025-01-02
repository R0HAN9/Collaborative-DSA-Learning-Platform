package com.Collaborative.DSALearningPlatform.Configurations;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Configuration class for Redis integration in the Collaborative DSA Learning Platform.
 * This class enables caching and sets up a RedisTemplate bean for Redis operations.
 */
@Configuration
@EnableCaching // Enables Spring's annotation-driven caching mechanism
public class RedisConfig {

    /**
     * Configures and provides a RedisTemplate bean for interacting with the Redis data store.
     * 
     * @param factory the RedisConnectionFactory that provides the connection to the Redis server.
     * @return a fully configured RedisTemplate instance.
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        // Create a new RedisTemplate for handling Redis operations.
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        
        // Set the connection factory for the RedisTemplate.
        template.setConnectionFactory(factory);
        
        // Return the configured RedisTemplate instance.
        return template;
    }
}
