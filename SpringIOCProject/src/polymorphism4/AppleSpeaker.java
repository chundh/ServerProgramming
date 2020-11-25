package polymorphism4;

import org.springframework.stereotype.Component;

/**
 * Speaker��� ����� Ư���� interface�� ����, ������ü�� �����Ѵ�.
 * �׷��� speaker�� �ٲܶ��� java�ڵ�� ���ϴ°��� ����, xml���θ� �ٲ��ָ� �ȴ�.
 * @author Chun
 *
 */
@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		System.out.println("-->AppleSpeaker ����");
	}
	
    public void volumeUp(){
        System.out.println("AppleSpeaker---�Ҹ� Ű���");
    }
    
    public void volumeDown(){
        System.out.println("AppleSpeaker---�Ҹ� ���δ�");
    }

	public AppleSpeaker getInstance() {
		return new AppleSpeaker();
	}
}
