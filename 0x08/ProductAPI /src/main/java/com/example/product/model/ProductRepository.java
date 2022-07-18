package com.example.product.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();
  
    public List<Product> getAllProducts() {
        return list;
    }
  
    public Product getProductById(Long id) {
      for(Product product : list){
        if(id.equals(product.getId())){
            return product;
        }
      }
      return null;
    }
  
    public void addProduct(Product s) {
      list.add(s);
    }
  
    public void updateProduct(Product s) {
        for (Product product :list) {
            if(product.getId().equals(s.getId())){
                int positioon = list.indexOf(product);
                product.setCode(s.getCode());
                product.setCreatedOne(s.getCreatedOne());
                product.setDescription(s.getDescription());
                product.setName(s.getName());
                product.setPrice(s.getPrice());
                product.setStatus(s.isStatus());
                list.set(positioon,product);
            }
        }
     }
  
     public void removeProduct(Product s) {
       list.remove(s);
     }
  
     public void addList(List<Product> listOfProducts) {
       list.addAll(listOfProducts);
     }
  }
  