package edu.kh.jdbc.rentcar.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.rentcar.main.view.MainView;
import edu.kh.jdbc.rentcar.model.service.ReservationService;
import edu.kh.jdbc.rentcar.model.vo.Reservation;
import edu.kh.jdbc.rentcar.model.vo.ReservationList;

public class ReservationView {
	
	private Scanner sc = new Scanner(System.in);
	
	private ReservationService vService = new ReservationService();
	
	public void reservationMenu() {
		
		int input = -1;
		
		do {
			try {
				System.out.println("\n***** 차량 예약 기능 *****\n");
				System.out.println("1. 차량 예약 조건 조회");
				System.out.println("2. 내 차량 예약 정보 조회");
				System.out.println("3. 차량 예약");
				System.out.println("4. 차량 예약 취소");
				System.out.println("0. 이전으로 돌아가기");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				case 1 : searchAll(); break;
				case 2 : myReservation(); break;
				case 3 : reserve(); break;
				case 4 :  break;
				case 0 :  System.out.println("이전으로 돌아갑니다."); break;
				default : System.out.println("메뉴 번호만 입력 해주세요.");
				
				
				}
				
				System.out.println();
				
				
			}catch(InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>");
				sc.nextLine();
			}
			
		}while(input != 0);
		
	}
	
	
	private void searchAll() {
		
		int input = -1;
		
		do {
			try {
				
				System.out.println("\n***** 차종 선택 *****\n");
				System.out.println("1) 국산차");
				System.out.println("2) 외제차");
				System.out.println("3) 바이크");
				System.out.println("0) 이전으로 돌아가기");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				
				case 1 : domesticCar(); break;
				case 2 : foreginCar(); break;
				case 3 : motorcycle(); break;
				case 0 :  System.out.println("이전으로 돌아갑니다."); break;
				default : System.out.println("메뉴 번호만 입력 해주세요.");
				
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다.>>");
				sc.nextLine();
				
			}
		} while(input != 0);
		
		
	}


	private void domesticCar() {

		System.out.println("\n[국산차]\n");
		
		try {
			
			List<Reservation> reservationList = vService.domesticCar();
			
			if(reservationList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(Reservation v : reservationList) {
					System.out.printf("%s | %d | %s | %s | %s\n",
								v.getReservationRcname(),
								v.getReservationAge(),
								v.getReservationPrice(),
								v.getReservationArea(),
								v.getReservationDate());
								
				}
				
			}
			
		} catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
			
		}
		
	}
	
	private void foreginCar() {

		System.out.println("\n[외제차]\n");
		
		try {
			
			List<Reservation> reservationList = vService.foreginCar();
			
			if(reservationList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(Reservation v : reservationList) {
					System.out.printf("%s | %d | %s | %s | %s\n",
								v.getReservationRcname(),
								v.getReservationAge(),
								v.getReservationPrice(),
								v.getReservationArea(),
								v.getReservationDate());
								
				}
				
			}
			
		} catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
			
		}
		
	}
	
	private void motorcycle() {

		System.out.println("\n[외제차]\n");
		
		try {
			
			List<Reservation> reservationList = vService.motorcycle();
			
			if(reservationList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(Reservation v : reservationList) {
					System.out.printf("%s | %d | %s | %s | %s\n",
								v.getReservationRcname(),
								v.getReservationAge(),
								v.getReservationPrice(),
								v.getReservationArea(),
								v.getReservationDate());
								
				}
				
			}
			
		} catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
			
		}
		
	}
	
	
	private void reserve() {
		
		try {
		System.out.println("[예약하기]");
		
		String reservationListRcname = null;
		String member2Nm = null;
		String insurance = null;
		
		System.out.print("차량 이름 : ");
		reservationListRcname = sc.next();
		
		System.out.println("예약자명 : ");
		member2Nm = sc.next();
		
		System.out.println();
		while(true) {
		
		System.out.println("보험 종류 메뉴");
		System.out.println("1. 자차보험");
		System.out.println("2. 파손보험");
		System.out.println("3. 누구나 보험");
		System.out.println("4. 가족보험");
		System.out.println();
		System.out.print("보험 선택 : ");
		insurance = sc.next();
		
		System.out.println();
		
		
		if(insurance.equals("자차보험") || insurance.equals("파손보험") || insurance.equals("누구나보험") ||insurance.equals("가족보험")) {
			break;
		}
		else {
			System.out.println("메뉴에 작성된 보험만 입력 해주세요");
		}
		System.out.println();
		}
		ReservationList reservationList = new ReservationList();
		reservationList.setReservationListRcname(reservationListRcname);
		reservationList.setMember2Nm(member2Nm);
		reservationList.setInsurance(insurance);
		reservationList.setMember2No(MainView.loginMember2.getMember2No());
		
		int result = vService.reserve(reservationList);
		
		if(result > 0) {
			System.out.println("예약 완료");
		}else {
			System.out.println("예약 실패");
		}
		System.out.println();
		
		}catch(Exception e) {
			System.out.println("\n<<차량 예약 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
	}
	
	private void myReservation() {
		
		System.out.println("\n[내 차량 예약 정보 조회]\n");
		
		try {
			System.out.println("회원 번호 입력 : ");
			int member2No = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
			ReservationList	reservationList = vService.myReservation(MainView.loginMember2.getMember2No());
			
			if(reservationList != null) {
				System.out.printf("%d %d %s %s %s %s\n",
						reservationList.getMember2No(),
						reservationList.getReservationListNo(),
						reservationList.getReservationListRcname(),
						reservationList.getMember2Nm(),
						reservationList.getInsurance(),
						reservationList.getReservationDt());
				
			}
		
		}catch(Exception e) {
			System.out.println("\n[해당 번호에 예약정보가 존재하지 않습니다.]\n");
			e.printStackTrace();
			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
