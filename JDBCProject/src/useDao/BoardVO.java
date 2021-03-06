package useDao;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ValueObject 쿼리의 데이터에 해당하는 변수를 설정하고 해당 객체에 데이터를 넣으면서 어느정도 정확한 데이터의 입력을 유도할 수 있다.
// VO를 사용해서 후에 생길 변화에도 유연하게 유지보수할 수 있다.
/*@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@Data // data가 위의 lombok을 다 포함한다.
public class BoardVO {
	// 테이블의 컬럼 이름과 동일한 멤버변수 (데이터 타입까지)를 private으로 선언한다.
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	
}
