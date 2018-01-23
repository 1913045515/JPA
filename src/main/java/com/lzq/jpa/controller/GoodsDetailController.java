package com.lzq.jpa.controller;

import com.lzq.jpa.entity.Classify;
import com.lzq.jpa.entity.Goods;
import com.lzq.jpa.entity.GoodsDetail;
import com.lzq.jpa.entity.repository.GoodsDetailRepository;
import com.lzq.jpa.entity.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

@Controller
@RequestMapping(value = "jpa")
public class GoodsDetailController {
    @Autowired
    private GoodsDetailRepository goodsDetailRepository;

    @RequestMapping(value = "getGoods",method = RequestMethod.GET)
    @ResponseBody
    public Goods findByGoodsDetail(){
        GoodsDetail goodsDetail=goodsDetailRepository.getOne("1");
        return goodsDetail.getGoods();
    }
}
