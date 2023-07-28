package book.manager.service;

import book.manager.entity.AuthUser;

import javax.servlet.http.HttpSession;

public interface AuthService {
    void register(String username, String gender, String grade, String password);
    AuthUser findUser(HttpSession session);
}
