/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allkhmernews.wep.repository;


import com.allkhmernews.wep.model.Role;
import com.allkhmernews.wep.model.User;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository {
	
	@Select("Select id, username, password, status From tbuser  Where username=#{username}")
	@Results({
		
		@Result(property="roles", column="id", many=@Many(select="findRoleByUserId"))
	})
	User loadUserByUsername(String username);
	
	@Select("Select r.id, r.role From tbrole r Inner Join tbuser_role ur on r.id=ur.user_id Where ur.user_id=#{user_id}")
	List<Role> findRoleByUserId(int id);	
}