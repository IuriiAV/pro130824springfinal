package org.telran.social.model;

import org.springframework.stereotype.Component;
import org.telran.social.entity.Message;

import java.util.function.Predicate;

@Component
public class MessageNameFilter extends AbstractFilter {

    @Override
   public Predicate<Message> getFilter() {
        return null;
    }

    @Override
    public String field() {
        return "text";
    }
}
