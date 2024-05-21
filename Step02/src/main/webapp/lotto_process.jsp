<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Random r = new Random();
	ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
	
	int ea = Integer.parseInt(request.getParameter("ea"));
	
	for(int i=0;i<ea;i++){
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < 6){
			set.add(r.nextInt(45)+1);
		}
		list.add(set);
	}
	
	request.setAttribute("list", list);
	request.getRequestDispatcher("lotto_result.jsp").forward(request,response);
%>    






