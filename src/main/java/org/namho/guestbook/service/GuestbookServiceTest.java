package org.namho.guestbook.service;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.namho.guestbook.config.ApplicationConfig;
import org.namho.guestbook.dto.Guestbook;

public class GuestbookServiceTest {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService guestbookService = ac.getBean(GuestbookService.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("김남호");
        guestbook.setContent("testing...");
        guestbook.setRegdate(new Date());
        Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
        System.out.println(result);
    }
}
