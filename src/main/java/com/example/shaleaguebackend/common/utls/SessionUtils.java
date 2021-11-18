package com.example.shaleaguebackend.common.utls;

import com.example.shaleaguebackend.model.domain.Admin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtils {
    private static final String USERKEY = "sessionUser";

    public static HttpSession session(boolean create) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(create); // true == allow create
    }
    public static HttpSession session(){return session(true);}

    public static Admin getCurrentUserInfo() {
        return (Admin) session().getAttribute(USERKEY);
    }

    public static void saveCurrentUserInfo(Admin admin) {
        session(false).setAttribute(USERKEY, admin);
    }

    public static void deleteCurrentUserInfo() {
        session().invalidate();
    }
}
