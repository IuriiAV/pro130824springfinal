package org.telran.mth.mailService;

import java.util.*;

public class MailApp {

    public static boolean inWork = true;

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("johnsmith@mail.com", "John"),
                new User("sarahswong@mail.com", "Sarah"),
                new User("michaelbrown@mail.com", "Michael"),
                new User("emilyjones@mail.com", "Emily"),
                new User("danielclark@mail.com", "Daniel"),
                new User("oliviawilson@mail.com", "Olivia"),
                new User("williamdavis@mail.com", "William"),
                new User("jessicadavis@mail.com", "Jessica"),
                new User("matthewmartin@mail.com", "Matthew"),
                new User("laurachavez@mail.com", "Laura")
        );
        Map<String, User> userMap = new HashMap<>();
        for (User user : users) {
            userMap.put(user.getEmail(), user);
        }
        new Thread(new MailDistributor(userMap)).start();
        creatThreads(users);
    }

    private static void creatThreads(List<User> users) {
        List<Thread> threads = new ArrayList<>();
        for (User user : users) {
            threads.add(new Thread(new CheckEmail(user)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}