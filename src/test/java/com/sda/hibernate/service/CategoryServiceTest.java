package com.sda.hibernate.service;

import com.sda.hibernate.dao.CategoryDao;
import com.sda.hibernate.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    private static CategoryDao categoryDao;

    @BeforeEach
    public void beforeTests(){
        categoryDao = new CategoryDao();
    }

    @Test
    void save() {
        Category category = new Category();
        category.setName("TestowaKategoria");
        assertNotNull(categoryDao.save(category));

    }
}