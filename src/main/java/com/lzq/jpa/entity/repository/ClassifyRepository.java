package com.lzq.jpa.entity.repository;

import com.lzq.jpa.entity.Classify;
import com.lzq.jpa.entity.Goods;
import com.lzq.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

public interface ClassifyRepository extends JpaRepository<Classify,String>{
    /**
     * 相当于 select *from classify where name=?
     * @param name
     * @return
     */
    public List<Classify> findByName(String name);
}
