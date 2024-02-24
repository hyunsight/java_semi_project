package semi01.project;

public class DoubleRoomReservation extends RoomReservation{
    double saleRatio; //할인율

    public DoubleRoomReservation() {
        this.reservedRoomType = "double";
        this.roomLimitNum = 2;
        this.roomPrice = 200000;
        this.serveBreakfast = "미포함";
    }
    public DoubleRoomReservation(String reservedName, int reservedPeriod, String reservedRoomType) {
        super.reservedName = reservedName;
        super.reservedPeriod = reservedPeriod;
        super.reservedRoomType = "double";
        this.roomLimitNum = 2;
        this.roomPrice = 200000;
        this.serveBreakfast = "미포함";
        this.saleRatio = 0.05;
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
