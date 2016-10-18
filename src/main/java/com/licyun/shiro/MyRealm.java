package com.licyun.shiro;

import com.licyun.model.User;
import com.licyun.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        String email = principalCollection.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        //根据email查询用户角色
        Set<String> roles = userService.findRolesByEmail(email) ;
        //根据email查询用户权限
        Set<String> permissions = userService.findPermissionsByEmail(email);
        //将用户角色和权限分别赋值给info，便于shiro拦截链处理
        info.setRoles(roles);
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
        String email = (String)token.getPrincipal();  //得到邮箱
        String password = new String((char[])token.getCredentials()); //得到密码;
        User user = userService.findByEmail(email);

        if (user != null){
            if(!email.equals(user.getEmail())){
                throw new UnknownAccountException(); //如果邮箱错误
            }
            if(!password.equals(user.getPassword())){
                throw new IncorrectCredentialsException(); //如果密码错误
            }
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(email, password, getName());
            return authenticationInfo ;
        }else{
            return  null ;
        }
    }
}
