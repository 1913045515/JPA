package com.lzq.jpa.entity.repository;

import com.lzq.jpa.entity.Address;
import com.lzq.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

public interface AddressRepository extends JpaRepository<Address,String>{
    /**
     * 相当于 select *from address where name=?
     * @param name
     * @return
     */
    public List<Address> findByName(String name);
}
