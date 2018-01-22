package com.lzq.jpa.controller;
import com.lzq.jpa.entity.User;
import com.lzq.jpa.entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by qiang on 2018/1/22.
 */

@Controller
@RequestMapping(value = "jpa")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "findByName",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    @RequestMapping(value = "findByHeightBetween",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByHeightBetween(int start,int end){
        return userRepository.findByHeightBetween(start,end);
    }

    @RequestMapping(value = "findByHeightLessThan",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByHeightLessThan(int less){
        return userRepository.findByHeightLessThan(less);
    }

    @RequestMapping(value = "findByHeightGreaterThan",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByHeightGreaterThan(int greater){
        return userRepository.findByHeightGreaterThan(greater);
    }

    @RequestMapping(value = "findByNameAndHeight",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameAndHeight(String name,int height){
        return userRepository.findByNameAndHeight(name,height);
    }

    @RequestMapping(value = "findByNameOrHeight",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameOrHeight(String name,int height){
        return userRepository.findByNameOrHeight(name,height);
    }

    @RequestMapping(value = "findByNameIsNull",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameIsNull(){
        return userRepository.findByNameIsNull();
    }

    @RequestMapping(value = "findByNameIsNotNull",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameIsNotNull(){
        return userRepository.findByNameIsNotNull();
    }

    @RequestMapping(value = "findByNameOrderByHeightDesc",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameOrderByHeightDesc(String name){
        return userRepository.findByNameOrderByHeightDesc(name);
    }

    @RequestMapping(value = "findByNameOrderByHeightAsc",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameOrderByHeightAsc(String name){
        return userRepository.findByNameOrderByHeightAsc(name);
    }


    @RequestMapping(value = "findByNameLike",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameLike(String name){
        return userRepository.findByNameLike("%"+name+"%");
    }

    @RequestMapping(value = "findByNameNotLike",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameNotLike(String name){
        return userRepository.findByNameNotLike("%"+name+"%");
    }

    @RequestMapping(value = "findByNameNot",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByNameNot(String name){
        return userRepository.findByNameNot(name);
    }

    @RequestMapping(value = "findByIdIn",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByIdIn(String ids){
        List<String>list=new ArrayList<>();
        String[] idsStr=ids.split(",");
        for(String id:idsStr){
            list.add(id);
        }
        return userRepository.findByIdIn(list);
    }

    @RequestMapping(value = "findByIdNotIn",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByIdNotIn(String ids){
        List<String>list=new ArrayList<>();
        String[] idsStr=ids.split(",");
        for(String id:idsStr){
            list.add(id);
        }
        return userRepository.findByIdNotIn(list);
    }
}
