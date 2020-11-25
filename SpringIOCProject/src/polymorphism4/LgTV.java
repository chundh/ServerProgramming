package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	// Type Injection이다.
	// 변수의 타입을 기준으로 알아서 의존성 주입을 처리한다.
	// 해당 타입의 객체가 메모리에 있으면, 컨테이너가 그 객체를 변수에 할당한다.
	// 메모리에 할당할 객체가 없으면, Exception이 발생된다.
	@Autowired
	private Speaker speaker;
	
    public LgTV() {
        System.out.println("===> LgTV(1) 생성");
    }

	@Override
    public void powerOn(){
        System.out.println("LgTV---전원 킨다");
    }
    @Override
    public void powerOff(){
        System.out.println("LgTV---전원 끈다");
    }
    @Override
    public void volumeUp(){
        speaker.volumeUp();
    }
    @Override
    public void volumeDown(){
        speaker.volumeDown();
    }
}
