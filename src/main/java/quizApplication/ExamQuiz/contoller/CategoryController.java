package quizApplication.ExamQuiz.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import quizApplication.ExamQuiz.entity.Category;
import quizApplication.ExamQuiz.service.CategoryService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> category = categoryService.getCategories();
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Long catId){
        Category category = categoryService.getCategory(catId);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId, @RequestBody Category category){

      Category category1 = categoryService.updateCategory(categoryId, category);
      return ResponseEntity.status(HttpStatus.OK).body(category1);
    }


    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long catId){
         categoryService.deleteCategory(catId);
         ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
