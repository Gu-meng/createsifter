package com.oierbravo.createsifter.compat.kubejs;

import com.mojang.datafixers.util.Either;
import com.oierbravo.createsifter.content.contraptions.components.sifter.SifterBlockEntity;
import dev.latvian.mods.kubejs.create.ProcessingRecipeSchema;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.BooleanComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface SiftingRecipeSchema extends ProcessingRecipeSchema {
    RecipeKey<Boolean> WATERLOGGED = BooleanComponent.BOOLEAN.key("waterlogged").optional(false);
    RecipeKey<Float> MINIMUM_SPEED = NumberComponent.FLOAT.key("minimumSpeed").optional(1.0f);
    class SiftingRecipeJS extends RecipeJS {
        public RecipeJS waterlogged() {
            return setValue(WATERLOGGED, true);
        }

    }
    RecipeSchema SIFTING = new RecipeSchema(SiftingRecipeJS.class, SiftingRecipeJS::new, RESULTS, INGREDIENTS, PROCESSING_TIME_REQUIRED,HEAT_REQUIREMENT, WATERLOGGED, MINIMUM_SPEED);


}
