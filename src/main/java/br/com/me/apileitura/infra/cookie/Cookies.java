package br.com.me.apileitura.infra.cookie;

import br.com.me.apileitura.summary.Chapter;
import br.com.me.apileitura.summary.Summary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class Cookies {

    public void createCookie(String key, Object object, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie(key, new ObjectMapper().writeValueAsString(object));
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
