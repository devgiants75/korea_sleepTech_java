package otherPackage;

// 부모 클래스
public class OtherClass {
	protected String otherField = "다른 패키지의 필드";
	
	protected void otherMethod() {
		System.out.println("다른 패키지의 메서드");
	}
	
	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		System.out.println(publicClass.publicField);
		publicClass.publicMethod();
	}
}
