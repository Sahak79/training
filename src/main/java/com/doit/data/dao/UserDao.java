package com.doit.data.dao;

import com.doit.data.User;
import com.doit.exception.DatabaseException;
import com.doit.exception.EntityNotFoundException;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public interface UserDao {

    void add(User user) throws DatabaseException;

    User getByID(long id) throws EntityNotFoundException, DatabaseException;

    boolean isEmailExist(String email) throws DatabaseException;

    boolean isEmailExist(String email, Long excludedUserID) throws DatabaseException;

    User getByEmail(String email) throws DatabaseException;

}
