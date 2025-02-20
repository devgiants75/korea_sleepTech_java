package chapter11;

/*
 * == SOLID 원칙 ==
 * SRP: 단일 책임 원칙
 * OCP: 개방 폐쇄 원칙
 * LSP: 리스코프 치환 원칙 - 자식 클래스는 부모 클래스를 대체할 수 있어야 함
 * ISP: 인터페이스 분리 원칙
 * DIP: 의존 역전 원칙 - 클래스 간의 결합을 낮추고, 추상화에 의존해야 함
 * */

// == SOLID 원칙을 활용한 주문 관리 시스템 == //
// 1. SRP - Order 클래스는 주문 정보를 저장하는 역할만 담당
class Order {
	private String orderId; // 각 주문의 식별번호
	private int amount; // 주문 금액
	
	public Order(String orderId, int amount) {
		this.orderId = orderId;
		this.amount = amount;
	}
	
	public String getOrderId() { return orderId; }
	public int getAmount() { return amount; }
}

// 2. OCP - 결제 프로세스를 추상화한 인터페이스 생성
interface PaymentProcessor {
	void processPayment(Order order); // 주문 객체를 받아 결제를 처리하는 메서드
}

class CreditCardPaymentProcessor implements PaymentProcessor {
	@Override
	public void processPayment(Order order) {
		System.out.println("신용카드로 결제합니다: " + order.getOrderId());
	}
}

class SamSungPayPaymentProcessor implements PaymentProcessor {
	@Override
	public void processPayment(Order order) {
		System.out.println("삼성페이로 결제합니다: " + order.getOrderId());
	}
}

// 3. ISP - 주문 보고서 생성을 위한 별도의 인터페이스
interface GenerateReport {
	void generateReport(Order order);
}

class PdfReportGenerator implements GenerateReport {
	@Override
	public void generateReport(Order order) {
		System.out.println("주문 정보 보고서를 PDF 파일로 생성: " + order.getOrderId());
	}
}

// 4. DIP - OrderService 클래스는 결제 및 보고서 생성 인터페이스에 의존
class OrderService {
	private final PaymentProcessor paymentProcessor;
	private final GenerateReport generateReport;
	
	// 생성자에서 결제 처리기 & 보고서 생성기 객체를 주입 (인터페이스와의 의존을 주입)
	public OrderService(PaymentProcessor paymentProcessor, GenerateReport generateReport) {
		this.paymentProcessor = paymentProcessor;
		this.generateReport = generateReport;
	}
	
	void placeOrder(Order order) {
		paymentProcessor.processPayment(order);
		generateReport.generateReport(order);
		System.out.println("주문 완료!");
	}
}

public class C_OOP_Prac {
	public static void main(String[] args) {
		
		PaymentProcessor CreditCardpaymentProcessor = new CreditCardPaymentProcessor();
		PaymentProcessor SamSungPayPaymentProcessor = new SamSungPayPaymentProcessor();
		GenerateReport generateReport = new PdfReportGenerator();
		
		OrderService orderService1 = new OrderService(CreditCardpaymentProcessor, generateReport);
		OrderService orderService2 = new OrderService(SamSungPayPaymentProcessor, generateReport);
		
		// 여러 개의 주문 객체 생성
		Order order1 = new Order("1", 18000);
		Order order2 = new Order("2", 22000);
		Order order3 = new Order("3", 15000);
		Order order4 = new Order("4", 11000);
		
		// 주문 처리 실행 
		orderService1.placeOrder(order1);
		orderService1.placeOrder(order2);
		orderService2.placeOrder(order3);
		orderService2.placeOrder(order4);		
	}
}