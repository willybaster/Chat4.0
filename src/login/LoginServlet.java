package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;
import dao.LoginDao;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();
		loginBean.setName(userName);
		loginBean.setPassword(password);

		LoginDao loginDao = new LoginDao();

		String userValidate = loginDao.authenticateUser(loginBean);

		if (userValidate.equals("SUCCESS")) {
			request.setAttribute("user", userName);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}

}
