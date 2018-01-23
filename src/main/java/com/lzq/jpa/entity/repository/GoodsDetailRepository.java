package com.lzq.jpa.entity.repository;

import com.lzq.jpa.entity.Goods;
import com.lzq.jpa.entity.GoodsDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

public interface GoodsDetailRepository extends JpaRepository<GoodsDetail,String>{
    /**
     * 相当于 select *from goods_detail where name=?
     * @param name
     * @return
     */
    public List<GoodsDetail> findByName(String name);
}
