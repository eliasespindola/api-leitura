package br.com.me.apileitura.infra.cookie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Component
public class Cookies {

    public Cookie createCookie(String key, Object object) {
        try {
            Cookie cookie = new Cookie(key, new ObjectMapper().writeValueAsString(object));
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            return cookie;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
