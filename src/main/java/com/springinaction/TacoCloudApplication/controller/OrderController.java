package com.springinaction.TacoCloudApplication.controller;

import com.springinaction.TacoCloudApplication.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "orders")
@SessionAttributes("tacoOrder")
@Slf4j
public class OrderController {

    @GetMapping("current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {
        if ( errors.hasErrors() ) {
            return "orderForm";
        }

        log.info("Order submitted: {}", order);
        // with setComplete method we are ensuring that the session is cleaned up
        // and ready for a new order the next time the user creates taco.
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
