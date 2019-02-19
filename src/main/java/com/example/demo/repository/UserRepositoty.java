package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {
    /*
    * 根据用户名查询
    * */
    @Query("select t from User t where t.firstName = :name")
    User findByUserName(@Param("name") String name);

    /*
    * 查询全部
    * */
    @Query("select t from User t")
    List<User> find();

    /*
    * 删除  必须加入@Modifying和@Transactional
    * */
    @Modifying
    @Transactional
    @Query("delete from User u where u.id=:id")
    public int deleteUserById(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query("update User u set u.firstName = :name where u.id=:id")
    public int queryUserById(@Param("id") Integer id,@Param("name") String name);

}