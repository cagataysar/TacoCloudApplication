package com.springinaction.TacoCloudApplication.web;

import com.springinaction.TacoCloudApplication.model.Ingredient;
import com.springinaction.TacoCloudApplication.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springinaction.TacoCloudApplication.model.Ingredient;
import com.springinaction.TacoCloudApplication.data.JdbcIngredientRepository;

@Component
public class IngredientByIdConverter implements Converter< String, Ingredient > {
    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter (IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert (String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
