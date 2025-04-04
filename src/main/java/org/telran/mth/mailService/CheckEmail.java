package org.telran.mth.mailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckEmail implements Runnable {

    private User user;

    private int countEmail;

    public CheckEmail(User user) {
        this.user = user;
        this.countEmail = user.getEmailList().size();
    }

    @Override
    public void run() {
        while (MailApp.inWork){
            if (countEmail != user.getEmailList().size()) {
                log.info("You have new email {}", user.getEmailList().get(user.getEmailList().size()-1));
                countEmail++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
