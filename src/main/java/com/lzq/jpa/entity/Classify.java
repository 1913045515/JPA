package com.lzq.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="classify")
public class Classify implements Serializable {
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(name = "goods_classify_links",
            joinColumns= { @JoinColumn(name = "goods_id", referencedColumnName = "id") }
            , inverseJoinColumns = { @JoinColumn(name = "classify_id", referencedColumnName = "id") }
            ,inverseForeignKey = @ForeignKey(name = "fk_mr_links_goods_classify")
            ,foreignKey = @ForeignKey(name = "fk_mr_links_classify_goods"))
    private List<Goods> goodses= new ArrayList<>();

    public Classify() {
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

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }
}
