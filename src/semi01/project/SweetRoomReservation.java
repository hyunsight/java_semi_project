package semi01.project;

public class SweetRoomReservation extends RoomReservation{
    double saleRatio; //할인율

    public SweetRoomReservation() {
        this.reservedRoomType = "sweet";
        this.roomPrice = 500000;
        this.serveBreakfast = "포함";
        this.roomLimitNum = 0;
    }
    public SweetRoomReservation(String reservedName, int reservedPeriod, String reservedRoomType) {
        super.reservedName = reservedName;
        super.reservedPeriod = reservedPeriod;
        super.reservedRoomType = reservedRoomType;
        this.roomPrice = 500000;
        this.serveBreakfast = "포함";
        this.saleRatio = 0.2;
    }

    @Override
    public int calcPrice(int reservedPeriod) {
        if (reservedPeriod >= 3) {
            reservedPrice = (roomPrice * reservedPeriod) - (int)(roomPrice * reservedPeriod * saleRatio);
            return reservedPrice; }
        else {reservedPrice = roomPrice * reservedPeriod;
            return reservedPrice;
        }
    }
}
