package com.lzq.jpa.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

@Entity
@Table(name="address")
public class Address implements Serializable {
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
     * 地址详情信息
     */
    @Column(name = "detail", nullable = true, length = 100)
    private String detail;

    /**
     * 地址所创建者的用户信息
     */
    @ManyToOne
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    public Address() {
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
