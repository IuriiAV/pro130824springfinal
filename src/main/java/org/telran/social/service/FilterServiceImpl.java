package org.telran.social.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.social.entity.Message;
import org.telran.social.model.AbstractFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class FilterServiceImpl implements FilterService {

    private static Map<String, AbstractFilter> filterMap = new HashMap<>();

    @Autowired
    private List<AbstractFilter> filters = new ArrayList<>();

    @PostConstruct
    public void init() {
        filters.forEach( filter ->
                filterMap.put(filter.field(), filter));
    }

    @Override
    public Predicate<Message> filter(List<String> fields) {
        Predicate<Message> messagePredicate = null;
        for(String field : fields) {
            AbstractFilter abstractFilter = filterMap.get(field);
            if (messagePredicate != null) {
                messagePredicate.and(abstractFilter.getFilter());
            } else {
                messagePredicate = abstractFilter.getFilter();
            }
        }
        return messagePredicate;
    }
}
