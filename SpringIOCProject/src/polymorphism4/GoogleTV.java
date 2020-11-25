package polymorphism4;

public class GoogleTV implements TV {
	private int price;
	
    public GoogleTV() {
        System.out.println("===> GoogleTV 생성");
    }
    public void initialize() {
    	System.out.println("--> 멤버변수 초기화");
    	this.price = 120;
    }
    public void destroy() {
    	System.out.println("--> 자원해제");
    }
    
    @Override
    public void powerOn(){
        System.out.println("GoogleTV---전원 킨다.");
    }
    @Override
    public void powerOff(){
        System.out.println("GoogleTV---전원 끈다.");
    }
    @Override
    public void volumeUp(){
        System.out.println("GoogleTV---소리 키운다.");
    }
    @Override
    public void volumeDown(){
        System.out.println("GoogleTV---소리 낮춘다.");
    }
}
