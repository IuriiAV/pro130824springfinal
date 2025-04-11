package org.telran.social.model;

import org.telran.social.entity.Message;

import java.util.function.Predicate;

public class MessageAuthorFilter extends AbstractFilter {

    @Override
   public Predicate<Message> getFilter() {
        return null;
    }

    @Override
   public String field() {
        return "sender";
    }
}
