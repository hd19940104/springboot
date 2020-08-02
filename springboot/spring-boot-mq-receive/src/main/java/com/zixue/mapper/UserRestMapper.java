package com.zixue.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.zixue.beans.User;

@Repository
public abstract interface UserRestMapper
{
  public abstract int insertUser(User paramUser);

  public abstract int updateUser(User paramUser);

  public abstract int deleteUser(int paramInt);

  public abstract User findUserById(int paramInt);

  public abstract List<User> findUserAll();

  public abstract User findUserByName(String paramString);
}

