package springbasic.cook;

// 요리사를 정의한다.
//Chef 클래스가 has a 관계로 보유한 FriPan 클래스에게 상당히 의존적이기
//때문에 만일 FriPan가 삭제되거나 변경되었을때 Chef까지 영향을 받는다.

public class Chef {
	
	private Pan pan; // has a 관계 ( 강하게 결합되어 있다. 외부의 변환에 대해 유연하지 못함)
	
	public Chef() {
		//pan = new FriPan(); // 직접 생성할 필요 있어?? new 연산자 뒤에는 정확한 자료형을 명시해야 하기 떄문에
		//Chef와 FriPan 간에 결합도가 너무 강해진다. 따라서 이 결합도를 느슨하게 하기 위해서는 앞으로는 객체를 자바코드안에서
		//직접 new 연산자를 사용하여 생성하는 코드는 피하도록 하자.
	}
	
	//setter 메서드 준비 ( 스프링이 전달한 객체를 넘겨받기 위해서)
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
	//요리를 만든다.
	public void cook() {
		pan.warm();
	}
	
	
}
