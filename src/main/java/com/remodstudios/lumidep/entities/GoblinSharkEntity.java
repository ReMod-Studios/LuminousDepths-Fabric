package com.remodstudios.lumidep.entities;

import com.remodstudios.lumidep.items.ItemRegistry;
import com.remodstudios.lumidep.tags.TagsRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;

public class GoblinSharkEntity extends DolphinEntity {
    public GoblinSharkEntity(EntityType<? extends DolphinEntity> entityType, World world) {
        super(entityType, world);
    }
    protected void initGoals(){
        this.goalSelector.add(0, new TemptGoal(this, 1.2D, Ingredient.fromTag(TagsRegistry.SHINY), false));
    }
<<<<<<< HEAD
=======
    // Pichu: Post Gradle Arc, was here.
>>>>>>> 8e6658b (GIT BASH YOU FUCKING CUNT)
}