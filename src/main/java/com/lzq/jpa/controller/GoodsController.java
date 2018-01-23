package com.lzq.jpa.controller;

import com.lzq.jpa.entity.*;
import com.lzq.jpa.entity.repository.GoodsRepository;
import com.lzq.jpa.entity.repository.UserRepository;
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
public class GoodsController {
    @Autowired
    private GoodsRepository goodsRepository;

    @RequestMapping(value = "findByClassify",method = RequestMethod.GET)
    @ResponseBody
    public List<Classify> findByClassify(){
        Goods goods=goodsRepository.getOne("1");
        List<Classify> list=goods.getClassifies();
        for(Classify classify:list){
            classify.setGoodses(null);
        }
        return list;
    }

    @RequestMapping(value = "getGoodsDetail",method = RequestMethod.GET)
    @ResponseBody
    public GoodsDetail findByGoodsDetail(){
        Goods goods=goodsRepository.getOne("1");
        return goods.getGoodsDetail();
    }
}
