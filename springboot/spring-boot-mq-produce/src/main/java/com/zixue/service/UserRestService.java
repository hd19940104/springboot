package com.zixue.service;

import com.zixue.beans.User;
import java.util.List;

public abstract interface UserRestService
{
  public abstract int addUser(User paramUser);

  public abstract int updateUser(User paramUser);

  public abstract int deleteUser(Integer paramInteger);

  public abstract User findUserById(Integer paramInteger);

  public abstract List<User> findAll();
  public abstract List<User> selectAll();
  public abstract User findUserByName(String paramString);
}

