package com.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

 protected FilterConfig filterConfig = null;
 protected String encoding = "";
 
 public void destroy() {
  filterConfig = null;
  encoding = null;
 }

 public void doFilter(ServletRequest request, ServletResponse response,
   FilterChain chain) throws IOException, ServletException {
  if(encoding!=null){
   request.setCharacterEncoding(encoding);
   chain.doFilter(request, response);
  }
 }

 public void init(FilterConfig arg0) throws ServletException {
  this.filterConfig = arg0;
  this.encoding = arg0.getInitParameter("encoding");
 }

}