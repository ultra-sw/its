package ru.ultrasoftware.its.service.impl;

import org.springframework.stereotype.Service;
import ru.ultrasoftware.its.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Override
    public String authorize(String username, String password) {
        //TODO Authorize against LDAP
        if("user".equals(username) && "password".equals(password)) {
            return "Василий Пупкин";
        }
        return null;
    }
}
