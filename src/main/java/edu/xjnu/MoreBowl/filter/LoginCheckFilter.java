package edu.xjnu.MoreBowl.filter;

import com.alibaba.fastjson.JSON;
import edu.xjnu.MoreBowl.common.BaseContext;
import edu.xjnu.MoreBowl.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vstay
 * @date 2022/5/31 下午 8:18
 */

@Slf4j
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("请求的URI ====>>>  requestURI: {}", requestURI);

        // 2. 判断本次请求是否需要处理
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**"
        };

        // 3. 如果不需要处理,直接放行
        if (check(urls, requestURI)){
            // log.info("不需要处理,直接放行: {}", requestURI);
            filterChain.doFilter(request, response);
            return;
        };
        // 4. 判断登录状态,如果已登录,直接放行
        if (request.getSession().getAttribute("employee")!=null){
            // log.info("已登录,直接放行 用户ID为: {}", request.getSession().getAttribute("employee"));
            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request,response);
            return;
        }

        // log.info("未登录,跳转到登录页面");
        // 5. 如果未登录, 返回未登录结果. 通过输出流方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
