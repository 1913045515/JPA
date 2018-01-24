package com.lzq.jpa.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="user")
public class User implements Serializable {
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

    /**
     * 用户所创建的地址信息
     */
    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "user")
    private List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
