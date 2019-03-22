package com.yingxs.shiro.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthorizingRealm {

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("[FirstRealm] --> doGetAuthenticationInfo ");
		// 1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 2.从UsernamePasswordToken中获取username
		String username = upToken.getUsername();
		// 3.调用数据库的方法，从数据库中查询username对象的记录
		System.out.println("从数据库中获取username:"+username+"所对应的用户信息.");
		// 4.若用户不存在则可以抛出UnknownAccountException异常
		if ( "unknown".equals(username) ) {
			throw new UnknownAccountException("用户不存在");
		}
		// 5.根据用户信息的情况，决定是否需要抛出其他异常
		if ( "monster".equals(username) ) {
			throw new LockedAccountException("用户被锁定");
		}
		
		// 6.根据用户情况构建AuthenticationInfo对象并返回；通常使用的实现类为SimpleAuthenticationInfo
		
		// 1.principal 认证的实体信息可以是usernmae也可以是用户的实体类对象
		Object principal = username;
		// 2.credentials 密码
		Object credentials = null;
		if ("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		} else if("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		}
		// 3.realmName 当前realm对象的name 调用父类的getName()即可
		String realmName = getName();
		// 4.盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials, credentialsSalt, realmName);

		
		return info;
	}
	
	public static void main(String[] args) {
		String hashAlgoritthmName="MD5";
		Object credentials="123456";
		Object salt = ByteSource.Util.bytes("user");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgoritthmName, credentials, salt, hashIterations);
		System.out.println(result);
		
	}

	//授权 会被shiro回调的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 1.从PrincipalCollection中获取登陆用户得到信息
		Object principal = principals.getPrimaryPrincipal();
		
		//2.利用登陆的用户的信息获取当前用户的角色或权限
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if("admin".equals(principal)) {
			roles.add("admin");
		}
		
		//3.创建SimpleAuthorizationInfo 并设置其reles属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		//4.返回SimpleAuthorizationInfo对象
		return info;
	}


	
}
