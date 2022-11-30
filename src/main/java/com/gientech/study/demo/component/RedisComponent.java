package com.gientech.study.demo.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RedisComponent {

    private RedisTemplate redisTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RedisComponent(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * HasKey
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Set
     *
     * @param key
     * @param value
     */
    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Set
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Set
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            String json = objectMapper.writeValueAsString(value);
            if (time > 0) {
                redisTemplate.opsForValue().set(key, json, time, TimeUnit.SECONDS);
            } else {
                set(key, json);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * Get
     *
     * @param key
     * @return
     */
    public <T> T get(String key, Class<T> clazz) throws IOException {
        Object res = redisTemplate.opsForValue().get(key);
        return res == null ? null : objectMapper.readValue(res.toString(), clazz);
    }
}
