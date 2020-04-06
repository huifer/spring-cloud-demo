package org.huifer.springcloud.servicea.config;

import com.google.gson.Gson;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class GsonConfigForRedis<T> implements RedisSerializer<T> {
    private Class<T> clazz;
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public GsonConfigForRedis() {
    }

    public GsonConfigForRedis(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        Gson gson = new Gson();
        return gson.toJson(t).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String s = new String(bytes, DEFAULT_CHARSET);
        Gson gson = new Gson();
        return gson.fromJson(s, clazz);
    }
}
