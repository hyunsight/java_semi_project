package customer.project;

//silver 등급 (일반 고객)
public class Customer {
    //필드
    // - GoldCustomer, VIPCustomer 클래스에서 가져다 쓰기 위해 protected 선언 (단, 다른 패키지 사용 불가)
    protected int customerID; //고객 ID
    protected String customerName; //고객 이름
    protected String customerGrade; //고객 등급
    public int bonusPoint; //적립된 보너스 포인트
    double bonusRatio; //적립할 보너스 포인트 비율 (silver는 0.01)

    //생성자
    public Customer() {
        initCustomer();
    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;

        initCustomer();
    }

    //고객들을 초기화 메소드
    //(참조) 클래스 외부에서 쓸 경우, public/ 클래스 내부에서만 쓸 경우, private
    private void initCustomer() {
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }

    //보너스 포인트 적립과 가격 리턴 메소드
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio); //포인트 적립
        return price;
    }

    //해당 고객 정보 보여주는 메소드
    public String showCustomerInfo() {
        return customerName + "님의 등급: " + customerGrade + ", 보너스 포인트: " + bonusPoint + "점";
    }

    //다른 패키지에 있는 CustomerApplication 클래스에서 사용하기 위한 메소드 (getter & setter)
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }
}


