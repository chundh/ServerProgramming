package polymorphism4;

public class GoogleTV implements TV {
	private int price;
	
    public GoogleTV() {
        System.out.println("===> GoogleTV ����");
    }
    public void initialize() {
    	System.out.println("--> ������� �ʱ�ȭ");
    	this.price = 120;
    }
    public void destroy() {
    	System.out.println("--> �ڿ�����");
    }
    
    @Override
    public void powerOn(){
        System.out.println("GoogleTV---���� Ų��.");
    }
    @Override
    public void powerOff(){
        System.out.println("GoogleTV---���� ����.");
    }
    @Override
    public void volumeUp(){
        System.out.println("GoogleTV---�Ҹ� Ű���.");
    }
    @Override
    public void volumeDown(){
        System.out.println("GoogleTV---�Ҹ� �����.");
    }
}
