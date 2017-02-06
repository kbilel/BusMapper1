//package fr.philae.filters;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import fr.philae.beans.LoginBean;
//
//@WebFilter( "/pages/admin/*")
//public class myfilter implements Filter{
//
//    /**
//     * Checks if user is logged in. If not it redirects to the login.xhtml page.
//     */
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//     
//    	System.out.println("enter dofilter");// Get the loginBean from session attribute
//        LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
//         
//        // For the first application request there is no loginBean in the session so user needs to log in
//        // For other requests loginBean is present but we need to check if user has logged in successfully
//        if (loginBean == null || !loginBean.getUserConnected()) {
//            String contextPath = ((HttpServletRequest)request).getContextPath();
//            ((HttpServletResponse)response).sendRedirect(contextPath + "/loginboot.jsf");
//        }
//      
//        chain.doFilter(request, response);
//             
//    }
// 
//    public void init(FilterConfig config) throws ServletException {
//        // Nothing to do here!
//    }
// 
//    public void destroy() {
//        // Nothing to do here!
//    }  
//
//}
