package com.aiit.realm;

import com.aiit.pojo.Permission;
import com.aiit.pojo.Role;
import com.aiit.pojo.User;
import com.aiit.service.IUserService;
import com.aiit.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.Set;

/**
 * @author: jhzhong
 * @date: 2023/3/5 20:51
 * @desc:
 */
@Component(value = "myRealm")
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        UserServiceImpl userService = (UserServiceImpl) ContextLoader.getCurrentWebApplicationContext().getBean("userService");
        String principal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = userService.queryRolesByLoginName(principal);
        Set<String> permissions = userService.queryPermissionByLoginName(principal);
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
//        UserServiceImpl userService = (UserServiceImpl) ContextLoader.getCurrentWebApplicationContext().getBean("userService");
        User user = userService.queryUserByLoginName(principal);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(principal, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}
