package com.studentpal.parents.controller;

import com.studentpal.parents.dto.Card;
import com.studentpal.parents.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController extends BaseController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/parents/cards")
    public ResponseWrapper<List<Card>> getCards(@RequestHeader(value = "Access-Token") String token,
                                                @RequestParam(value = "child_id", required = false, defaultValue = "0") int childId,
                                                @RequestParam(value = "card_id", required = false, defaultValue = "0") int cardId) {
        return ResponseWrapper.succeed(cardService.findAll());
    }
}
