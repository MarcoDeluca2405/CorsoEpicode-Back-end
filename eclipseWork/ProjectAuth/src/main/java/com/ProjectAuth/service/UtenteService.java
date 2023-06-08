package com.ProjectAuth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ProjectAuth.model.User;



@Service
public class UtenteService {

	@Value("${user-admin}") private String admin;
	@Value("${pass-admin}") private String admin_pass;
	
	@Value("${user}") private String users;
	@Value("${pass}") private String user_pass;
	
	
	public String loginUser(User user) {
		System.out.println(user.getUsername());
		System.out.println(users);
		System.out.println(user.getUsername()==users);
		if(user.getUsername().equals(admin)&&user.getPassword().equals(admin_pass)) {
			return "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>homePage</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<div class=\"container\">\r\n"
					+ "	\r\n"
					+ "	<h2 class=\"text-center py-2\">Home Page</h2>\r\n"
					+"<h2 class=\"text-center py-2\">Sei un admin</h2>\r\n"
					+ "<a href='api/admin'>login as admin </a>\r\n"
					+ "</div>\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>";
			
		}else if(user.getUsername().equals(users)&&user.getPassword().equals(user_pass)) {
			return "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>homePage</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<div class=\"container\">\r\n"
					+ "	\r\n"
					+ "	<h2 class=\"text-center py-2\">Home Page</h2>\r\n"
					+"<h2 class=\"text-center py-2\">Sei un utente</h2>\r\n"
					+ "<a href='api/utente'>login as utente </a>\r\n"
					+ "</div>\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>";
			
		}else {
			return "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>homePage</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<div class=\"container\">\r\n"
					+ "	\r\n"
					+ "	<h2 class=\"text-center py-2\">Home Page</h2>\r\n"
					+"<div class=\"alert alert-warning\" role=\"alert\">\r\n"
					+ "  Credeziali errate\r\n"
					+ "</div>"
					+ "<form th:object=\"${userLogin}\" th:action=\"@{/api}\" method=\"post\">\r\n"
					+ "  <div class=\"mb-3\">\r\n"
					+ "    <label for=\"username\" class=\"form-label\">username:</label>\r\n"
					+ "    <input type=\"text\" name=\"username\" th:field=\"*{username}\" class=\"form-control\" id=\"username\" aria-describedby=\"username\">\r\n"
					+ "  </div>\r\n"
					+ "  <div class=\"mb-3\">\r\n"
					+ "    <label for=\"password\" class=\"form-label\">Password:</label>\r\n"
					+ "    <input type=\"password\" name=\"password\" th:field=\"*{password}\" class=\"form-control\" id=\"password\">\r\n"
					+ "  </div>\r\n"
					+ "  <button type=\"submit\" class=\"btn btn-primary\">Login</button>\r\n"
					+ "</form>\r\n"
					+ "</div>\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</body>\r\n"
					+ "</html>";
		}
	}
	
}
