package semi01.project.appliction;

import semi01.project.RoomReservation;
import semi01.project.DoubleRoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;


import java.util.Scanner;
import java.util.ArrayList;

public class RoomReservationApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<RoomReservation> reservationList = new ArrayList<>();

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("--------------------");
            System.out.println("1. 호텔 예약하기 | 2. 호텔 예약 내역 확인하기 | 3. 호텔 룸 정보 보기 | 4. 호텔 예약 고객 정보 보기 | 5. 종료");
            System.out.println("--------------------");

            System.out.print("선택: ");

            int selectNo = scanner.nextInt();

            switch (selectNo) {
                case 1: roomReserve();
                    break;
                case 2: roomReservationCheck();
                    break;
                case 3: roomInfo();
                    break;
                case 4: reservationInfo();
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
    }

    //1. 호텔 예약하기
    public static void roomReserve() {
        System.out.println("----------");
        System.out.println("호텔 예약하기");
        System.out.println("----------");

        System.out.print("예약자명: ");
        String reservedName = scanner.next();
        System.out.print("예약일수: ");
        int reservedPeriod = scanner.nextInt();
        System.out.print("예약룸: ");
        String reservedRoomType = scanner.next();
        System.out.print("예약인원: ");
        int reservedNum = scanner.nextInt();

        RoomReservation roomReservation = null;

        if (reservedRoomType.equals("single")) {
        roomReservation = new RoomReservation(reservedName, reservedPeriod, reservedRoomType); }
        else if(reservedRoomType.equals("double")) {
            roomReservation = new DoubleRoomReservation(reservedName, reservedPeriod, reservedRoomType);
        } else if(reservedRoomType.equals("twin")) {
            roomReservation = new TwinRoomReservation(reservedName, reservedPeriod, reservedRoomType);
        } else if(reservedRoomType.equals("sweet")) {
            roomReservation = new SweetRoomReservation(reservedName, reservedPeriod, reservedRoomType);
        }

        if (reservedNum <= roomReservation.roomLimitNum) {
        reservationList.add(roomReservation);

        System.out.println("예약 내역");
        System.out.println(roomReservation.showRoomReservationInfo());
        System.out.println("지불 금액: " + roomReservation.calcPrice(reservedPeriod));
        System.out.println(reservationList.get(0)); }
        else System.out.println("최대 가능 인원을 초과하였습니다.");
    }

    //2. 호텔 예약 내역 확인하기(스캐너로 입력받은 예약자명으로 특정 고객의 예약 정보 보기)
    public static void roomReservationCheck() {
        System.out.println("----------");
        System.out.println("호텔 예약 내역 확인하기");
        System.out.println("----------");

        System.out.print("예약자명: ");
        String reservedName = scanner.next();

        RoomReservation resultRoomreservation = null;

        for (RoomReservation roomReservation : reservationList) {
            if(roomReservation.getReservedName().equals(reservedName)) {
                System.out.println(roomReservation.showRoomReservationInfo());
                break;
            }
        }
    }

    //3. 호텔 룸 정보 보기 (모든 룸의 정보 보기(룸이름, 가격, 인원제한, 조식 제공여부))
    public static void roomInfo() {
        System.out.println("----------");
        System.out.println("호텔 룸 정보 보기");
        System.out.println("----------");

        RoomReservation roomReservation1 = new RoomReservation();
        DoubleRoomReservation roomReservation2 = new DoubleRoomReservation();
        TwinRoomReservation roomReservation3 = new TwinRoomReservation();
        SweetRoomReservation roomReservation4 = new SweetRoomReservation();

        // Output information about each room type
        System.out.println("룸 타입: " + roomReservation1.getReservedRoomType() + "가격: " + roomReservation1.roomPrice + ", 조식 제공 여부: " + roomReservation1.serveBreakfast);
        System.out.println("룸 타입: " + roomReservation2.getReservedRoomType() + "가격: " + roomReservation2.roomPrice + ", 조식 제공 여부: " + roomReservation2.serveBreakfast);
        System.out.println("룸 타입: " + roomReservation3.getReservedRoomType() + "가격: " + roomReservation3.roomPrice + ", 조식 제공 여부: " + roomReservation3.serveBreakfast);
        System.out.println("룸 타입: " + roomReservation4.getReservedRoomType() + "가격: " + roomReservation4.roomPrice + ", 조식 제공 여부: " + roomReservation4.serveBreakfast);
    }

    // 4. 호텔 예약 고객 정보 보기 (모든 고객의 예약 정보 보기(룸이름, 예약 일수, 조식 제공여부)
    public static void reservationInfo() {
        for (RoomReservation roomReservation : reservationList) {
            System.out.println(roomReservation.showRoomReservationInfo() + roomReservation.serveBreakfast);
        }
    }
}
