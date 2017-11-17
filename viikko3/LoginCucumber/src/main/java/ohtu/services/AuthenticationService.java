package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() >= 3) {
            if (password.length() >= 8) {
                int nums = 0;
                char[] t = password.toCharArray();
                for (char i : t) {
                    if (isNum(i)) {
                        nums++;
                        break;
                    }
                }
                if (nums > 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isNum(char c) {
        if (c == '1') {
            return true;
        } else if (c == '2') {
            return true;
        } else if (c == '3') {
            return true;
        } else if (c == '4') {
            return true;
        } else if (c == '5') {
            return true;
        } else if (c == '6') {
            return true;
        } else if (c == '7') {
            return true;
        } else if (c == '8') {
            return true;
        } else if (c == '9') {
            return true;
        } else if (c == '0') {
            return true;
        }
        return false;
    }
}
