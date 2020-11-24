package useDao;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ValueObject ������ �����Ϳ� �ش��ϴ� ������ �����ϰ� �ش� ��ü�� �����͸� �����鼭 ������� ��Ȯ�� �������� �Է��� ������ �� �ִ�.
// VO�� ����ؼ� �Ŀ� ���� ��ȭ���� �����ϰ� ���������� �� �ִ�.
/*@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@Data // data�� ���� lombok�� �� �����Ѵ�.
public class BoardVO {
	// ���̺��� �÷� �̸��� ������ ������� (������ Ÿ�Ա���)�� private���� �����Ѵ�.
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	
}