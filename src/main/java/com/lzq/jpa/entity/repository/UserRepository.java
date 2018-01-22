package com.lzq.jpa.entity.repository;
import com.lzq.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by qiang on 2018/1/22.
 */

public interface UserRepository extends JpaRepository<User,String>{
    /**
     * 相当于 select *from user where name=?
     * @param name
     * @return
     */
    public List<User> findByName(String name);

    /**
     * 相当于select *from user where name like ?
     * 但是有一点需要注意的是，%需要我们自己来写
     * @param name
     * @return
     */
    public List<User> findByNameLike(String name);

    /**
     * 相当于select *from user where name not like ?
     * 但是有一点需要注意的是，%需要我们自己来写
     * @param name
     * @return
     */
    public List<User> findByNameNotLike(String name);

    /**
     * 相当于 select *from user where name <> ?
     * @param name
     * @return
     */
    public List<User> findByNameNot(String name);

    /**
     * 相当于 select *from user where id in (?)
     * @param ids
     * @return
     */
    public List<User> findByIdIn(List<String> ids);

    /**
     * 相当于 select *from user where id not in ()
     * @param ids
     * @return
     */
    public List<User> findByIdNotIn(List<String> ids);

    /**
     * 相当于 select *from user where name=? order by height desc
     * @param name
     * @return
     */
    public List<User> findByNameOrderByHeightDesc(String name);

    /**
     * 相当于 select *from user where name=? order by height asc
     * @param name
     * @return
     */
    public List<User> findByNameOrderByHeightAsc(String name);

    /**
     * 相当于 select *from user where name is null
     * @return
     */
    public List<User> findByNameIsNull();

    /**
     * 相当于 select *from user where name is not null
     * @return
     */
    public List<User> findByNameIsNotNull();

    /**
     * 相当于 select *from user where name =? and height=?
     * @param name
     * @param height
     * @return
     */
    public List<User> findByNameAndHeight(String name,int height);

    /**
     * 相当于 select *from user where name =? or height=?
     * @param name
     * @param height
     * @return
     */
    public List<User> findByNameOrHeight(String name,int height);

    /**
     * 相当于 select *from user where height between ? and ?
     * 需要注意的是mysql是有包含两个端点值的
     * @param start
     * @param end
     * @return
     */
    public List<User> findByHeightBetween(int start,int end);

    /**
     * 相当于 select *from user where height < ?
     * 需要注意的是mysql是没有包含端点值的
     * @param less
     * @return
     */
    public List<User> findByHeightLessThan(int less);

    /**
     * 相当于 select *from user where height > ?
     * 需要注意的是mysql是没有包含端点值的
     * @param greater
     * @return
     */
    public List<User> findByHeightGreaterThan(int greater);
}
