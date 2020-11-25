package polymorphism4;

import org.springframework.stereotype.Component;

/**
 * Speaker라는 공통된 특성을 interface로 묶고, 구현객체를 구성한다.
 * 그래서 speaker를 바꿀때도 java코드는 변하는것이 없고, xml내부만 바꿔주면 된다.
 * @author Chun
 *
 */
@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("-->AppleSpeaker 생성");
	}
	
    public void volumeUp(){
        System.out.println("AppleSpeaker---소리 키운다");
    }
    
    public void volumeDown(){
        System.out.println("AppleSpeaker---소리 줄인다");
    }

	public AppleSpeaker getInstance() {
		return new AppleSpeaker();
	}
}
