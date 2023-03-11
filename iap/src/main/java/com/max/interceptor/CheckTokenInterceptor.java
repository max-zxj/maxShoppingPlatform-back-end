package com.max.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.maxmall.vo.ResStatus;
import com.max.maxmall.vo.ResultVO;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行options请求
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");
        System.out.println("-------------"+token);
        if(token == null){
            ResultVO resultVO = new ResultVO(ResStatus.FAIL, "请先登录!",null);   //提示请先登录
            doResponse(response,resultVO);
        }else {
            try { //验证token
                String key = "MAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXMAXzhang";
                JwtParser parser = Jwts.parser(); //解析token的SigningKey必须和生成token时设置密码一致
                parser.setSigningKey(key); //如果token正确(密码正确，有效期内)则正常执行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "登录过 期，请重新登录!", null);
                doResponse(response, resultVO);
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "Token不 合法，请自重!", null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "请先登 ", null);
                doResponse(response, resultVO);
            }
        }
        return false;
    }


    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }
}
