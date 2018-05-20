package register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import dao.RegistrationDao;

public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();

		loginBean.setName(userName);
		loginBean.setPassword(password);

		RegistrationDao registratrionDao = new RegistrationDao();

		String userValidate = registratrionDao.registerUser(loginBean);

		if (userValidate.equals("SUCCESS")) {
			request.setAttribute("user", userName);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
}
