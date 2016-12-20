package com.doit.data.dao.impl;

import com.doit.data.User;
import com.doit.data.dao.UserDao;
import com.doit.data.repository.UserRepository;
import com.doit.exception.DatabaseException;
import com.doit.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SahakBabayan on 12/17/2016.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository repository;

    @Override
    public void add(User user) throws DatabaseException {
        try {
            repository.save(user);
        }catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User getByID(long id) throws EntityNotFoundException, DatabaseException {
        try {
            return repository.findOne(id);
        }catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email) throws DatabaseException {
        try {
            return repository.isEmailExist(email);
        }catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean isEmailExist(String email, Long excludedUserID) throws DatabaseException {
        try {
            return repository.isEmailExist(email, excludedUserID);
        }catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws DatabaseException {
        try {
            return repository.findByEmail(email);
        }catch (Exception e) {
            throw new DatabaseException(e);
        }
    }
}
