package com.doit.data.service.impl;

import com.doit.data.User;
import com.doit.data.dao.UserDao;
import com.doit.data.internal.SessionUser;
import com.doit.data.service.UserService;
import com.doit.exception.DatabaseException;
import com.doit.exception.EntityNotFoundException;
import com.doit.exception.InternalServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false)
    public void add(User user) throws InternalServerException {
        try {
            String encPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encPassword);

            userDao.add(user);
        }catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws InternalServerException {
        try {
            return userDao.getByEmail(email);
        }catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public User getByID(long id) throws InternalServerException {
        try {
            return userDao.getByID(id);
        }catch (EntityNotFoundException | DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email) throws InternalServerException {
        try {
            return userDao.isEmailExist(email);
        }catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email, long excludedUserID) throws InternalServerException {
        try {
            return userDao.isEmailExist(email, excludedUserID);
        }catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User user = userDao.getByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("Invalid credentials");
            }
            return new SessionUser(user);
        }catch (DatabaseException e) {
            throw new InternalServerException(e);
        }
    }
}
