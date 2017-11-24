package ru.ultrasoftware.its.service;

import ru.ultrasoftware.its.security.OtrsAuthenticationInfo;

public interface SecurityService {
    OtrsAuthenticationInfo currentUser();
    void logout();
}
