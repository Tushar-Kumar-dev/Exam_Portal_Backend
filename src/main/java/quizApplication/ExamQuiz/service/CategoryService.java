package quizApplication.ExamQuiz.service;

import quizApplication.ExamQuiz.entity.Category;

import java.util.List;

public interface CategoryService {

     Category addCategory(Category category);
     List<Category> getCategories();
     Category getCategory(Long catId);
     Category updateCategory(Long catId, Category category);
     void deleteCategory(Long catId);

}
