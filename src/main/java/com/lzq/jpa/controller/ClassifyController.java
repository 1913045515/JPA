package com.lzq.jpa.controller;

import com.lzq.jpa.entity.Classify;
import com.lzq.jpa.entity.Goods;
import com.lzq.jpa.entity.repository.ClassifyRepository;
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
public class ClassifyController {
    @Autowired
    private ClassifyRepository classifyRepository;

    @RequestMapping(value = "findByGoods",method = RequestMethod.GET)
    @ResponseBody
    public List<Goods> findByGoods(){
        Classify classify=classifyRepository.getOne("1");
        List<Goods> list=classify.getGoodses();
        return list;
    }
}
