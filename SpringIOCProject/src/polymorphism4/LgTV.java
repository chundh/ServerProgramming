package polymorphism4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	// Type Injection�̴�.
	// ������ Ÿ���� �������� �˾Ƽ� ������ ������ ó���Ѵ�.
	// �ش� Ÿ���� ��ü�� �޸𸮿� ������, �����̳ʰ� �� ��ü�� ������ �Ҵ��Ѵ�.
	// �޸𸮿� �Ҵ��� ��ü�� ������, Exception�� �߻��ȴ�.
	@Autowired
	private Speaker speaker;
	
    public LgTV() {
        System.out.println("===> LgTV(1) ����");
    }

	@Override
    public void powerOn(){
        System.out.println("LgTV---���� Ų��");
    }
    @Override
    public void powerOff(){
        System.out.println("LgTV---���� ����");
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
