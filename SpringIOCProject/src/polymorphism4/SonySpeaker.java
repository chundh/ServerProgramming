package polymorphism4;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("-->SonySpeaker ����");
	}
	
    public void volumeUp(){
        System.out.println("SonySpeaker---�Ҹ� Ű���");
    }
    
    public void volumeDown(){
        System.out.println("SonySpeaker---�Ҹ� ���δ�");
    }

	public SonySpeaker getInstance() {
		return new SonySpeaker();
	}

}