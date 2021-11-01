package br.com.me.apileitura.infra.cookie;

import br.com.me.apileitura.summary.Chapter;
import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;

class CookiesTest {

    @Test
    void should_create_cookie_and_return_cookie()  {
        Cookies cookies = new Cookies();
        Chapter chapter = new Chapter("Titulo 1", "titulo pequeno", 1);

        Cookie cookie = cookies.createCookie("chapter", chapter);
        assertThat(cookie.getValue()).isEqualTo("{\"title\":\"Titulo 1\",\"text\":\"titulo pequeno\"}");
        assertThat(cookie.getName()).isEqualTo("chapter");
    }
}