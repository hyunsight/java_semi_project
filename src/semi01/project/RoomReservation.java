package semi01.project;

public class RoomReservation {
    //필드
    protected String reservedName; //예약자명
    protected int reservedPeriod; //예약일수
    protected String reservedRoomType; //예약룸타입
    public int roomLimitNum; //룸 제한인원
    public int reservedNum; //예약인원
    public int roomPrice; //룸 가격
    public int reservedPrice; //예약금액(총)
    public String serveBreakfast; //조식 제공 여부

    public RoomReservation() {
        this.reservedRoomType = "single";
        this.roomLimitNum = 1;
        this.roomPrice = 100000;
        this.serveBreakfast = "미제공";
    }

    //생성자
    public RoomReservation(String reservedName, int reservedPeriod, String reservedRoomType) {
        this.reservedName = reservedName;
        this.reservedPeriod = reservedPeriod;
        this.reservedRoomType = reservedRoomType;
        this.roomLimitNum = 1;
        this.roomPrice = 100000;
        this.serveBreakfast = "미제공";
    }

    //기능
      public String showRoomReservationInfo() {
        return "예약 일수: " + reservedPeriod + ", 예약 룸: " + reservedRoomType + ", 조식 제공 여부: " + serveBreakfast;
    }

    //예약 금액 계산 메소드
    public int calcPrice(int reservedPeriod) {
        reservedPrice = roomPrice * reservedPeriod;
        return reservedPrice;
    }

    //getter & setter 메소드
    public String getReservedName() {
        return reservedName;
    }

    public void setReservedName(String reservedName) {
        this.reservedName = reservedName;
    }

    public int getReservedPeriod() {
        return reservedPeriod;
    }

    public void setReservedPeriod(int reservedPeriod) {
        this.reservedPeriod = reservedPeriod;
    }

    public String getReservedRoomType() { return reservedRoomType; }

    public void setReservedRoomType(String reservedRoomType) {
        this.reservedRoomType = reservedRoomType;
    }
}
