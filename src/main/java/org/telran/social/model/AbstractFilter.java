package org.telran.social.model;

import org.telran.social.entity.Message;

import java.util.function.Predicate;

public abstract class AbstractFilter {

   public abstract Predicate<Message> getFilter();

   public abstract String field();

}
