package org.namho.guestbook.service;

import java.util.List;

import org.namho.guestbook.dto.Guestbook;

public interface GuestbookService {
    Integer LIMIT = 5;
    List<Guestbook> getGuestbooks(Integer start);
    int deleteGuestBook(Long id, String ip);
    Guestbook addGuestbook(Guestbook guestbook, String ip);
    int getCount();
}
