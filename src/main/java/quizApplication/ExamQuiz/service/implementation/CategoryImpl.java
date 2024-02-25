package quizApplication.ExamQuiz.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizApplication.ExamQuiz.dao.CategoryRepositry;
import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepositry categoryRepositry;

    public Category addCategory(Category category){

        return categoryRepositry.save(category);
    }

    public List<Category> getCategories(){

        List<Category> category = categoryRepositry.findAll();
        return category;
    }

    public Category getCategory(Long catId){
        Optional<Category> category = categoryRepositry.findById(catId);
        if(category.isPresent()){
             Category category1 = category.get();
             return  category1;
        }
        return null;
    }

    public Category updateCategory(Long catId, Category category){

        Category category1 = getCategory(catId);
        category1.setDescription(category.getDescription());
        category1.setTitle(category.getTitle());


        return categoryRepositry.save(category1);
    }

    public void deleteCategory(Long catId){
        Category category = getCategory(catId);
         categoryRepositry.delete(category);
    }




}
