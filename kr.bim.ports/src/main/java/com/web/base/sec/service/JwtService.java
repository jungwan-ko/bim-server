package com.web.base.sec.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.web.base.global.SysKeyword;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("jwtService")
public class JwtService {
	@Value("${Jwt.time}")
	private String jwtTime;
	@Value("${Jwt.key}")
	private String jwtKey;
	
	String scKey=null;
	@PostConstruct
	protected void jwtKeyCreate() {
		
		scKey = Base64.getEncoder().encodeToString(jwtKey.getBytes());
    }
	
	public String createToken(String paramId,String paramName,String paramEmail,String paramRoles) {
		paramRoles=paramRoles==null?"":paramRoles;
		String[] roles=paramRoles.split(",");
		List<String> listRoles=new ArrayList<String>();
		for(int i=0;i<roles.length;i++) {
			listRoles.add(roles[i]);
		}
		
        Claims claims = Jwts.claims().setSubject(paramId);
        claims.put(SysKeyword.JWT_KEY_EMAIL, paramEmail);
        claims.put(SysKeyword.JWT_KEY_NAME, paramName);
        claims.put(SysKeyword.JWT_KEY_ROLES, paramRoles);
        Date ext = new Date();
        ext.setTime(ext.getTime()+Long.parseLong(jwtTime));
        String rs= Jwts.builder()
                .setClaims(claims) 
                .setExpiration(ext)
                .signWith(SignatureAlgorithm.HS256, scKey)  
                .compact();
        return rs;
    }


    // 토큰에서 회원 정보 추출
    public String getId(String token) {
        return Jwts.parser().setSigningKey(scKey).parseClaimsJws(token).getBody().getSubject();
    }
    public String getInfo(String tocken,String key) {
    	Claims claims=Jwts.parser().setSigningKey(scKey).parseClaimsJws(tocken).getBody();
    	Object rs=claims.get(key);
    	return rs!=null?rs.toString():null;
    }

    public String resolveToken(HttpServletRequest request) {
    	
        return request.getHeader("Authorization");
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
        	
            Jws<Claims> claims = Jwts.parser().setSigningKey(scKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

}