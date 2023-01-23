package com.springinaction.TacoCloudApplication.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;
    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
