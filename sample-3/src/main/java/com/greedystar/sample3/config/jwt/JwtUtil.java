package com.greedystar.sample3.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */

public class JwtUtil {

    /**
     * 解析Token
     *
     * @param jsonWebToken   Token String
     * @param base64Security Base64Security Key
     * @return
     */
    public static Claims parseToken(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser().setSigningKey(base64Security).parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 生成Token
     *
     * @param phone    手机号
     * @param property 自定义的jwt公共属性（包括超时时长、签发者、base64Security key）
     * @return
     */
    public static String createToken(String phone, JwtProperty property) {
        Calendar calendar = Calendar.getInstance();
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
                .claim("phone", phone)
                .setIssuer(property.getIssuer())
                .signWith(SignatureAlgorithm.HS256, property.getBase64Security())
                .setExpiration(new Date(calendar.getTimeInMillis() + property.getExpiry())).setNotBefore(calendar.getTime());
        return builder.compact();
    }
}
