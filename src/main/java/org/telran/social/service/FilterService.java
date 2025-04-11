package org.telran.social.service;

import org.telran.social.entity.Message;

import java.util.List;
import java.util.function.Predicate;

public interface FilterService {

    Predicate<Message> filter(List<String> fields);
}
