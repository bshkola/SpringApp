package pw.bshkola.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("roleBasedTargetUrlResolver")
public class RoleBasedTargetUrlResolver extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		
		/*
		HttpSession session = request.getSession();
		
		SavedRequest savedRequest = (SavedRequest)session.getAttribute("SPRING_SECURITY_SAVED_REQUEST_KEY");
		if (savedRequest != null) {
			try {
				response.sendRedirect(savedRequest.getRedirectUrl());
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		response.sendRedirect("/SpringApp/categories");
	}
	
}
