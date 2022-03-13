package com.cg.oma.demo.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oma.demo.entities.Category;

@Repository("categoryRepo")
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
