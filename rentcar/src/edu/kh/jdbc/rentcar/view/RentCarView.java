package edu.kh.jdbc.rentcar.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.rentcar.model.service.RentCarService;
import edu.kh.jdbc.rentcar.model.vo.RentCar;

public class RentCarView {
	
	private Scanner sc = new Scanner(System.in);
	
	private RentCarService rService = new RentCarService();
	
	public void rentCarMenu() {
		
		int input = -1;
		
		do {
			
			try {
				
				System.out.println("\n***** 차량 조회 기능 *****\n");
				System.out.println("1. 국산차");
				System.out.println("2. 외제차");
				System.out.println("3. 바이크");
				System.out.println("4. 차량 검색");
				System.out.println("0. 이전으로 돌아가기");
				
				System.out.print("\n 메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				case 1 : domesticCar(); break;
				case 2 : foreginCar();break;
				case 3 : motorcycle(); break;
				case 4 : searchRentCar(); break;
				case 0 : System.out.println("이전으로 돌아갑니다."); break;
				default : System.out.println("메뉴 번호만 입력 해주세요.");
				
				}
				
				System.out.println();
				
			}catch (InputMismatchException e) {
				System.out.println("\n<<입력 형식이 올바르지 않습니다>>\n");
				sc.nextLine();
			}
			
		}while(input != 0);
		
	}
	
	private void domesticCar() {
		
		System.out.println("\n[국산차]\n");
		
		try {
			
			List<RentCar> rentCarList = rService.domesticCar();
			
			if(rentCarList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(RentCar r : rentCarList) {
					System.out.printf("%d | %s | %s | %s | %d | %d\n",
							r.getRentCarNo(),
							r.getRentCarTitle(),
							r.getRentCarName(),
							r.getFuel(),
							r.getModel(),
							r.getSeatNumber() );
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
	}
	
	private void foreginCar() {
		
		System.out.println("\n[외제차]\n");
		
		try {
			
			List<RentCar> rentCarList = rService.foreginCar();
			
			if(rentCarList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(RentCar r : rentCarList) {
					System.out.printf("%d | %s | %s | %s | %d | %d\n",
							r.getRentCarNo(),
							r.getRentCarTitle(),
							r.getRentCarName(),
							r.getFuel(),
							r.getModel(),
							r.getSeatNumber() );
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}

		
	}
	
	
	private void motorcycle() {
		System.out.println("\n[바이크]\n");
		
		try {
			
			List<RentCar> rentCarList = rService.motorcycle();
			
			if(rentCarList.isEmpty()) {
				System.out.println("차량이 존재하지 않습니다.");
			}else {
				
				for(RentCar r : rentCarList) {
					System.out.printf("%d | %s | %s | %s | %d | %d\n",
							r.getRentCarNo(),
							r.getRentCarTitle(),
							r.getRentCarName(),
							r.getFuel(),
							r.getModel(),
							r.getSeatNumber() );
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("\n<<차량 조회 중 예외 발생>>\n");
			e.printStackTrace();
		}
		
	}
	
	
	private void searchRentCar() {
		
		try {
			System.out.println("\n[차량 검색]\n");
			
			System.out.print("차량 이름 : ");
			String condition = sc.next();

			List<RentCar> rentCarList = rService.searchRentCar(condition);
				if(rentCarList.isEmpty()) {
					System.out.println("차량이 존재하지 않습니다.");
				}else {
					
					for(RentCar r : rentCarList) {
						System.out.printf("%d | %s | %s | %s | %d | %d\n",
								r.getRentCarNo(),
								r.getRentCarTitle(),
								r.getRentCarName(),
								r.getFuel(),
								r.getModel(),
								r.getSeatNumber() );
					}
				
				}
		
			
		}catch(Exception e) {
			System.out.println("\n<<차량 검색 중 예외 발생>>\n");
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
