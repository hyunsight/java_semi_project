package semi01.project;

public class TwinRoomReservation extends RoomReservation{
    double saleRatio; //할인율

    public TwinRoomReservation() {
        this.reservedRoomType = "twin";
        this.roomLimitNum = 3;
        this.roomPrice = 250000;
        this.serveBreakfast = "미포함";
    }
    public TwinRoomReservation(String reservedName, int reservedPeriod, String reservedRoomType) {
        super.reservedName = reservedName;
        super.reservedPeriod = reservedPeriod;
        super.reservedRoomType = reservedRoomType;
        this.roomLimitNum = 3;
        this.roomPrice = 250000;
        this.serveBreakfast = "미포함";
        this.saleRatio = 0.1;
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
