package org.telran.mth.mailService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Random;

public class MailDistributor implements Runnable {

    private Map<String, User> usersMap;

    public MailDistributor(Map<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    @Override
    public void run() {
        Path path = Path.of("/Users/dogoda/Tel•Ran/BE/pro130824springfinal/src/main/java/org/telran/mth/mailService/messages.txt");
        Random random = new Random();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Thread.sleep(random.nextLong(0, 9) * 500);
                String[] emailInfo = line.split(":", 2);
                Email email = new Email(emailInfo[1], emailInfo[0]);
                User user = usersMap.get(emailInfo[0]);
                user.getEmailList().add(email);
                System.out.println(user.getName().toUpperCase() + " received new email: " + email.getMessage());
            }
            MailApp.inWork = false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
