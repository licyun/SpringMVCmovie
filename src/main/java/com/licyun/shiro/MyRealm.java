package com.licyun.shiro;

import com.licyun.model.User;
import com.licyun.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by 李呈云
 * Description:Shiro自定义域
 * 2016/10/15.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 用于的权限的认证。
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = userService.findRolesByUserName(username) ;
        Set<String> permissions = userService.findPermissionsByUserName(username) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 首先执行这个登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码;
        User user = userService.findByName(username);
        if (user != null){
            if(!username.equals(user.getUsername())){
                throw new UnknownAccountException(); //如果用户名错误
            }
            if(!password.equals(user.getPassword())){
                throw new IncorrectCredentialsException(); //如果密码错误
            }
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
            return authenticationInfo ;
        }else{
            return  null ;
        }
    }
}
