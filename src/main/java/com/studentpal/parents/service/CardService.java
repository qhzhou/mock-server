package com.studentpal.parents.service;

import com.studentpal.parents.dto.Card;

import org.springframework.stereotype.Service;

@Service
public class CardService extends BaseService<Card> {
    @Override
    protected Class<Card> getType() {
        return Card.class;
    }
}
