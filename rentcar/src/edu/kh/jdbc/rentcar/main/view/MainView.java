package edu.kh.jdbc.rentcar.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.rentcar.main.service.MainService;
import edu.kh.jdbc.rentcar.member2.vo.Member2;
import edu.kh.jdbc.rentcar.model.vo.Reservation;
import edu.kh.jdbc.rentcar.view.RentCarView;
import edu.kh.jdbc.rentcar.view.ReservationView;

public class MainView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MainService service = new MainService();
	
	public static Member2 loginMember2 = null;
	
	private RentCarView rentCarView = new RentCarView();
	
	private ReservationView reservationView = new ReservationView();
	

	/**
	 * 메인메뉴 출력 메서드 
	 */
	public void mainMenu() {
		
		int input = -1;
		
		do {
			try {
				
				if(loginMember2 == null) {
					
					System.out.println("***** 환영합니다 *****\n");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 종료");
					System.out.println();
					
					System.out.print("선택 : ");
					input = sc.nextInt();
					sc.nextLine();
					
					switch(input) {
					case 1: login(); break;
					case 2: signUp(); break;
					case 0: System.out.println("종료합니다."); break;
					default : System.out.println("잘못 입력하셨습니다.");
					
					
					}
					
					
				} else {
					
					System.out.println("***** 회원 메뉴 *****");
					System.out.println("1. 차량 조회 ");
					System.out.println("2. 차량 예약");
					System.out.println("3. 내 정보 조회");
					System.out.println("0. 로그아웃");
					System.out.println("99. 프로그램 종료");
					
					System.out.print("\n메뉴 선택 : ");
					input = sc.nextInt();
					
					System.out.println();
					
					switch(input) {
					
					case 1 : rentCarView.rentCarMenu(); break;
					case 2 : reservationView.reservationMenu(); break;
					case 3 : selectMyInfo(); break;
					case 0 : loginMember2 = null;
							System.out.println("\n[로그아웃 되었습니다.]\n");
							input = -1;	break;
					case 99 : System.out.println("종료");
					System.exit(0);
					break;
					default : System.out.println("메뉴 번호만 작성해주세요");
					}
					
					
				}
				
			}catch (InputMismatchException e) {
				System.out.println("입력 방식이 올바르지 않습니다.");
				sc.nextLine();
			}
			
		}while(input != 0);

		
	}
	
	private void signUp() {
		
		System.out.println("[회원가입]");
		
		String member2Id = null;
		
		String member2Pw1 = null;
		String member2Pw2 = null;
		
		String member2Name = null;
		String member2Gender = null;
		
		String license = null;
		
		try {
			
			while(true) {
				
				System.out.print("아이디 입력 :");
				member2Id = sc.next();
				
				int result = service.idDupCheck(member2Id);
				
				System.out.println();
				
				if(result ==0) {
					System.out.println("[사용 가능한 아이디 입니다.]");
					break;
				} else {
					System.out.println("[이미 사용중인 아이디 입니다.]");
				}
				System.out.println();
				
			}
			
			while(true) {
				
				System.out.print("비밀번호 입력 : ");
				member2Pw1 = sc.next();
				
				System.out.println("비밀번호 확인 : ");
				member2Pw2 = sc.next();
				
				System.out.println();
				if (member2Pw1.equals(member2Pw2)) {
					System.out.println("[일치합니다.]");
					break;
				} else { 
					System.out.println("[비밀번호가 일치하지 않습니다. 다시 입력 해주세요.]");
				}
				System.out.println();
						
			}
			
			System.out.print("이름 입력 : ");
			member2Name = sc.next();
			
			while(true) {
			System.out.print("성별 입력(M/F) : ");
			member2Gender =sc.next().toUpperCase();
			
			System.out.println();
			if(member2Gender.equals("M") || member2Gender.equals("F")) {
				break;
			}else {
				System.out.println("[M,F 둘중 하나만 입력해주세요.]");
				
			}
			}
			
			while(true) {
				System.out.print("운전면허 여부 입력 : ");
				license = sc.next().toUpperCase();
				
				System.out.println();
				if(license.equals("Y") || license.equals("N")) {
					break;
				}else {
					System.out.println("[Y 또는 N만 입력 해주세요]");
				}
				System.out.println();
			}
			
			
			
			Member2 member2 = new Member2(member2Id, member2Pw2, member2Name, member2Gender, license);
			
			int result = service.signUp(member2);
			
			System.out.println();
			if (result > 0) {
				System.out.println("*****회원 가입 성공*****");
			} else {
				System.out.println("<<회원 가입 실패>>");
			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("\n<<회원 가입 중 예외 발생>>");
			e.printStackTrace();
		}
	}
		

	
	
	
	private void login() {
		System.out.println();
		System.out.println("[로그인]");
		
		System.out.print("아이디 : ");
		String member2Id = sc.next();
		
		System.out.print("비밀번호 : ");
		String member2Pw = sc.next();
		
		try {
			
			loginMember2 = service.login(member2Id, member2Pw);
			
			System.out.println();
			if(loginMember2 != null) {
				System.out.println(loginMember2.getMember2Name() + "님 환영합니다.");
				
			}else {
				System.out.println("정보가 일치하지 않습니다.");
			}
			
			System.out.println();
			
		}catch(Exception e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
			
		}
		
		
		
	}
	
	private void selectMyInfo() {
		System.out.println("\n[내 정보 조회]\n");
		
		System.out.println("회원 번호 : " + loginMember2.getMember2No());
		System.out.println("아이디 : " + loginMember2.getMember2Id());
		System.out.println("이름 : " + loginMember2.getMember2Name());
		
		System.out.print("성별 : " );
		
		if(loginMember2.getMember2Gender().equals("M")) {
			System.out.println("남");
		}else {
			System.out.println("여");
		}
		
		System.out.print("운전면허 여부 : ");
		
		if(loginMember2.getLicense().equals("Y")) {
			System.out.println("O");
		}else {
			System.out.println("X");
		}
		
		
		System.out.println("가입일 : " + loginMember2.getEnrollDate());
	
	
	}
	
}
