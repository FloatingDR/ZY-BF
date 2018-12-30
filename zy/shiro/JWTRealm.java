package cafuc.flyeat.zy.shiro;

import cafuc.flyeat.zy.model.User;
import cafuc.flyeat.zy.model.UserRoleLink;
import cafuc.flyeat.zy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JWTRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String account = JWTUtil.getAccount(token);
        if (account == null) {
            throw new AuthenticationException("invalid token");
        }
        User user = userService.selectByAccount(account);
        if (user == null) {
            throw new AuthenticationException("user not found");
        }
        if (!JWTUtil.verify(token, account, user.getLoginPassword())) {
            throw new AuthenticationException("username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = JWTUtil.getAccount(principalCollection.getPrimaryPrincipal().toString());
        User user = userService.selectByAccount(account);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for ( UserRoleLink ur : user.getUserRoleLinks() ) {
            simpleAuthorizationInfo.addRole(ur.getRole().getRoleName());
        }
        return null;
    }

}
