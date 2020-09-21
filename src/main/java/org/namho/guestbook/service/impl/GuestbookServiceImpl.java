package org.namho.guestbook.service.impl;

import org.namho.guestbook.dao.GuestbookDao;
import org.namho.guestbook.dao.LogDao;
import org.namho.guestbook.dto.Guestbook;
import org.namho.guestbook.dto.Log;
import org.namho.guestbook.service.GuestbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceImpl implements GuestbookService {
    @Autowired
    GuestbookDao guestbookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional // read 만 하는 method에 사용
    public List<Guestbook> getGuestbooks(Integer start) {
        return guestbookDao.selectAll(start, GuestbookService.LIMIT);
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestBook(Long id, String ip) {
        int deleteCount = guestbookDao.deleteById(id);
        Log log = new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insert(log);
        return deleteCount;
    }

    @Override
    @Transactional(readOnly = false)
    public Guestbook addGuestbook(Guestbook guestbook, String ip) {
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insert(guestbook);
        guestbook.setId(id);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);

        return guestbook;
    }

    @Override
    public int getCount() {
        return guestbookDao.selectCount();
    }
}
