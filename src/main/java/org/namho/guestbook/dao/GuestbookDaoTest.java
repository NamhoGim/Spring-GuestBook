package org.namho.guestbook.dao;

import org.namho.guestbook.config.ApplicationConfig;
import org.namho.guestbook.dto.Guestbook;
import org.namho.guestbook.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookDaoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("김남호");
        guestbook.setContent("testing");
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insert(guestbook);
        System.out.println("id :" + id);

        LogDao logDao = ac.getBean(LogDao.class);
        Log log = new Log();
        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);
    }
}
