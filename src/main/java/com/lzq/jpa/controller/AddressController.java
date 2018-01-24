package com.lzq.jpa.controller;

import com.lzq.jpa.entity.Address;
import com.lzq.jpa.entity.User;
import com.lzq.jpa.entity.repository.AddressRepository;
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

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "getAddress",method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAddress(){
        User user=userRepository.getOne("1");
        List<Address> list=user.getAddresses();
        return list;
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(){
        Address address=addressRepository.getOne("1");
        return address.getUser();
    }
}
