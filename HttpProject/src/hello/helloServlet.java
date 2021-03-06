package hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 클래스 작성 규칙
 * 1. HttpServlet 클래스를 상속해야한다.
 * 2. public 클래스로 만들어야한다.
 * 3. default 생성자가 있어야한다.
 * 4. 요청 방식(method)에 따라 doGet이나 doPost를 재정의(Override)한다.
 * 5. 부모(HttpServlet) 클래스의 메소드를 제정의 하지 않으면 상속된다. 
 * 		- 이미 구현 되어있는 부모클래스의 메소드로 실행이된다.
 * 
 * 최초 사용할 때는 메모리에 적재하고, 디폴트 생성자 호출, init의 과정을 거치면서 시간이 오래걸린다
 * 두번째 실행단계부터는 이미 메모리에 적재가 되어있으므로 쓰레드풀에 바로 들어가고, 쓰레드풀에서 쓰레드를 갖고와서 실행하게된다.
 * @author Chun
 *
 */

public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 웹 페이지가 호출되면 톰캣 안의 서블릿 엔진이 객체를 생성하고, doGet메소드를 호출한다.
	// 서블릿 엔진은 web.xml을 기반으로 생성된다.
	// 서블릿은 서블릿 엔진에 의해 생성된다.
	// 서블릿 엔진은 내부에 쓰레드풀을 갖고 있다. 그래서 우선순위에따라 쓰레드를 가져오고, doGet, doPost를 실행하게끔한다.
    public helloServlet() {
    	// 서블릿 객체에서는 반드시 디폴트 생성자가 필요하기 때문에 멤버 변수 초기화를 할 수 없다. 그래서 init메소드가 필요하다.
        System.out.println("--> helloservlet 객체 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("--> init 호출");
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// 쓰레드 풀에서 가져온 쓰레드에서 서비스 메소드를 호출한다.
    	// 부모 클래스의 service메소드에서는 req.method가 GET인지 POST인지 판단하고 doGet, doPost를 호출한다.
    	System.out.println("--> service 호출");
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--> doGet 메소드 생성");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--> doPost 메소드 생성");
	}

    @Override
    public void destroy() {
    	System.out.println("--> destroy 호출");
    }
    
    
}
