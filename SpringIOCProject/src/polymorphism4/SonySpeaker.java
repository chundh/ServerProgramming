package polymorphism4;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("-->SonySpeaker 积己");
	}
	
    public void volumeUp(){
        System.out.println("SonySpeaker---家府 虐款促");
    }
    
    public void volumeDown(){
        System.out.println("SonySpeaker---家府 临牢促");
    }

	public SonySpeaker getInstance() {
		return new SonySpeaker();
	}

}
