package com.lzq.jpa.controller;

import com.lzq.jpa.entity.Address;
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
public class AddressController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "findByAddress",method = RequestMethod.GET)
    @ResponseBody
    public List<Address> findByAddress(){
        User user=userRepository.getOne("5");
        List<Address> list=user.getAddresses();
        for(Address address:list){
            address.setUser(null);
        }
        return list;
    }
}
