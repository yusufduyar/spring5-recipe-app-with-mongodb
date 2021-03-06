package com.spring5.recipeapp.converters;

import com.spring5.recipeapp.commands.CategoryCommand;
import com.spring5.recipeapp.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void when_command_object_is_null_converter_returns_null() {
        assertNull(converter.convert(null));
    }

    @Test
    public void when_command_object_is_not_null_but_empty_converter_returns_empty() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        String idValue = "1";
        String description = "description";

        //given
        Category category = new Category();
        category.setId(idValue);
        category.setDescription(description);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        assertEquals(idValue,categoryCommand.getId());
        assertEquals(description,categoryCommand.getDescription());
    }

}