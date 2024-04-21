package com.mc.mcsq.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {//普通用户验证
            if(isProtectedUrl(request)) {
                log.info("普通用户验证");
//                System.out.println(request.getMethod());
                if(!request.getMethod().equals("OPTIONS"))
                    request = JwtUtil.validateTokenAndAddUserIdToHeader(request);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        try {//管理员验证
            if(isAdminUrl(request)) {
                log.info("管理用户验证");
//                System.out.println(request.getMethod());
                if(!request.getMethod().equals("OPTIONS"))
                    request = JwtUtil.validateAdminToken(request);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<String>();
        protectedPaths.add("/ums/user/info");
        protectedPaths.add("/ums/user/update");
        protectedPaths.add("/verify/add");
        protectedPaths.add("/verify/get/*");
        protectedPaths.add("/verify/update");
        protectedPaths.add("/verify/list/*");
        protectedPaths.add("/book/add");
        protectedPaths.add("/book/listme");
        protectedPaths.add("/post/create");
        protectedPaths.add("/post/update");
        protectedPaths.add("/post/delete/*");
        protectedPaths.add("/comment/add_comment");
        protectedPaths.add("/relationship/subscribe/*");
        protectedPaths.add("/relationship/unsubscribe/*");
        protectedPaths.add("/relationship/validate/*");

        boolean bFind = false;
        for( String passedPath : protectedPaths ) {
            bFind = pathMatcher.match(passedPath, request.getServletPath());
            if( bFind ) {
                break;
            }
        }
        return bFind;
    }

    private boolean isAdminUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<String>();
        protectedPaths.add("/verify/update");
        protectedPaths.add("/verify/list/*");
        protectedPaths.add("/verify/shenhe");
        boolean bFind = false;
        for( String passedPath : protectedPaths ) {
            bFind = pathMatcher.match(passedPath, request.getServletPath());
            if( bFind ) {
                break;
            }
        }
        return bFind;
    }

}