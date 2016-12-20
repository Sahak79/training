package com.doit.data.service;

import com.doit.data.User;
import com.doit.exception.InternalServerException;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
public interface UserService {

    void add(User user) throws InternalServerException;

    User getByEmail(String email) throws InternalServerException;

    User getByID(long id) throws InternalServerException;

    boolean isEmailExist(String email) throws InternalServerException;

    boolean isEmailExist(String email, long excludedUserID) throws InternalServerException;

}
