package hello;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������ Ŭ���� �ۼ� ��Ģ
 * 1. HttpServlet Ŭ������ ����ؾ��Ѵ�.
 * 2. public Ŭ������ �������Ѵ�.
 * 3. default �����ڰ� �־���Ѵ�.
 * 4. ��û ���(method)�� ���� doGet�̳� doPost�� ������(Override)�Ѵ�.
 * 5. �θ�(HttpServlet) Ŭ������ �޼ҵ带 ������ ���� ������ ��ӵȴ�. 
 * 		- �̹� ���� �Ǿ��ִ� �θ�Ŭ������ �޼ҵ�� �����̵ȴ�.
 * 
 * ���� ����� ���� �޸𸮿� �����ϰ�, ����Ʈ ������ ȣ��, init�� ������ ��ġ�鼭 �ð��� �����ɸ���
 * �ι�° ����ܰ���ʹ� �̹� �޸𸮿� ���簡 �Ǿ������Ƿ� ������Ǯ�� �ٷ� ����, ������Ǯ���� �����带 �����ͼ� �����ϰԵȴ�.
 * @author Chun
 *
 */

public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// �� �������� ȣ��Ǹ� ��Ĺ ���� ������ ������ ��ü�� �����ϰ�, doGet�޼ҵ带 ȣ���Ѵ�.
	// ������ ������ web.xml�� ������� �����ȴ�.
	// �������� ������ ������ ���� �����ȴ�.
	// ������ ������ ���ο� ������Ǯ�� ���� �ִ�. �׷��� �켱���������� �����带 ��������, doGet, doPost�� �����ϰԲ��Ѵ�.
    public helloServlet() {
    	// ������ ��ü������ �ݵ�� ����Ʈ �����ڰ� �ʿ��ϱ� ������ ��� ���� �ʱ�ȭ�� �� �� ����. �׷��� init�޼ҵ尡 �ʿ��ϴ�.
        System.out.println("--> helloservlet ��ü ����");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("--> init ȣ��");
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// ������ Ǯ���� ������ �����忡�� ���� �޼ҵ带 ȣ���Ѵ�.
    	// �θ� Ŭ������ service�޼ҵ忡���� req.method�� GET���� POST���� �Ǵ��ϰ� doGet, doPost�� ȣ���Ѵ�.
    	System.out.println("--> service ȣ��");
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--> doGet �޼ҵ� ����");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--> doPost �޼ҵ� ����");
	}

    @Override
    public void destroy() {
    	System.out.println("--> destroy ȣ��");
    }
    
    
}