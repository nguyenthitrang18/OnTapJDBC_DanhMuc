/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.List;
import model.Category;
import repository.CategoryRepository;

/**
 *
 * @author ADMIN
 */
public class CategoryService {
    private CategoryRepository repos;

    public CategoryService(){
        repos = new CategoryRepository();
    }
    
    public List<Category> getSrv(){
        return repos.getList();
    }
    
    public boolean insertSrv(Category c){
        return  repos.insert(c);
    }
    
    public boolean updateSrv(Integer id,Category c){
        return  repos.update(id, c);
    }
    
    public boolean deleteSrv(Integer id){
        return  repos.delete(id);
    }
    
    
}
