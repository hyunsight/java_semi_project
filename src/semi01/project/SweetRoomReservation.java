package semi01.project;

public class SweetRoomReservation extends RoomReservation{
    double saleRatio; //할인율

    public SweetRoomReservation() {
        this.reservedRoomType = "sweet";
        this.roomPrice = 500000;
        this.serveBreakfast = "제공";
    }
    public SweetRoomReservation(String reservedName, int reservedPeriod, String reservedRoomType) {
        super.reservedName = reservedName;
        super.reservedPeriod = reservedPeriod;
        super.reservedRoomType = reservedRoomType;
        this.roomLimitNum = reservedNum;
        this.roomPrice = 500000;
        this.serveBreakfast = "제공";
        this.saleRatio = 0.2;
    }

    @Override
    public int calcPrice(int reservedPeriod) {
        if (reservedPeriod >= 3) {
            reservedPrice = (roomPrice * reservedPeriod) - (int)(roomPrice * saleRatio);
            return reservedPrice; }
        else {reservedPrice = roomPrice * reservedPeriod;
            return reservedPrice;
        }
    }
}
