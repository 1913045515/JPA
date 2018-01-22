package com.lzq.jpa.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
/**
 * Created by qiang on 2018/1/22.
 */

@Entity
@Table(name="user")
public class User {
    @Id
    @GenericGenerator(name = "PKUUID", strategy = "uuid2")
    @GeneratedValue(generator = "PKUUID")
    @Column(length = 36)
    protected String id;

    /**
     * 名字
     */
    @Column(name = "name", nullable = true, length = 30)
    private String name;

    /**
     * 身高
     */
    @Column(name = "height", nullable = true, length = 10)
    private Integer height;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
