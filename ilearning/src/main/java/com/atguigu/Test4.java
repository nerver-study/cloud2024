package com.atguigu;

import javax.xml.bind.DatatypeConverter;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

public class Test4 {
    public static void main(String[] args) {
    	 String token = "eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJpYXQiOjE3MjMxODcxNTQsInN1YiI6IjE4MTg4NDI3MTc3OTEzMjIxMTQiLCJpc3MiOiJlbGVhcm4iLCJjb21wYW55Q29kZSI6Im1ldGxpZmUiLCJhY2NvdW50SWQiOiIxODE4ODQyNzE3NzkxMzIyMTE0Iiwib3JnVHlwZSI6IkFHRU5UIiwiY29tcGFueUlkIjoiMTMzOTA0MjYwNzUxMDE5NjIyNCIsInNpdGVDb2RlIjoibWV0bGlmZSIsInJlcXVlc3RJZCI6ImRiNWI0ZDFjLWFiNmUtNDk2MS1hMjBkLTA4NjVjZDcyNDcyNyIsImNvbXBhbnlOYW1lIjoibWV0TGlsZSIsIm5hbWUiOiIxODE4MTYzNTg0MjgzODI0MTMwIiwiZnVsbE5hbWUiOiLpmYjplZPnpaUiLCJzaXRlSWQiOiIxMzM2MTkwNDM0NDU5OTE0MjQwIiwiY2xhc3MiOiJjb20uZnVsYW4uYXBwbGljYXRpb24udG9rZW4uVG9rZW5Nb2RlbCIsImRvbWFpblVybCI6Imh0dHBzOi8vaWxlYXJuaW5nYXBwLm1ldGxpZmUuY29tLmNuIiwiZXhwIjoxNzIzNzkxOTU0LCJuYmYiOjE3MjMxODcxNTR9.QFng9-unAX09DHoU350_0SxnyYK78ZQEw20aq5H7zds";

         try {
             Claims claims = Jwts.parser()
                     .setSigningKey(DatatypeConverter.parseBase64Binary("ZWxlYXJu"))
                     .parseClaimsJws(token)
                     .getBody();
             System.out.println("令牌信息="+JSON.toJSONString(claims));
//             System.out.println("Subject: " + claims.getSubject());
//             System.out.println("Expiration: " + claims.getExpiration());
             
//             // 检查过期时间
//             if (claims.getExpiration().before(new Date())) {
//                 System.out.println("JWT Token已经过期");
//             }
         } catch (ExpiredJwtException e) {
             System.out.println("JWT Token已经过期");
         }
        
    }
}
