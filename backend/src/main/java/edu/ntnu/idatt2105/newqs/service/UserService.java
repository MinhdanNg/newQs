package edu.ntnu.idatt2105.newqs.service;

import edu.ntnu.idatt2105.newqs.model.user.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    public UserResponse get(UserRequest request)
    {
        return null;
    }
}
