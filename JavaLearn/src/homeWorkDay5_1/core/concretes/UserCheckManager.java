package homeWorkDay5_1.core.concretes;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;



import homeWorkDay5_1.Entities.concretes.User;
import homeWorkDay5_1.core.abstracts.UserCheckService;
import homeWorkDay5_1.dataAcces.abstracts.UserDao;

public class UserCheckManager implements UserCheckService {
	
	private  final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	@Override
	public boolean checkName(User user) {
		if((user.getFirstName().length() >= 2 ) &&
				(user.getLastName().length() >=2)){
			return true;
		}else {
			System.out.println("Ge�ersiz AD veya SOYAD (en az iki karakter olmal�)");
			return false;
		}
		
	}

	@Override
	public boolean checkMail(User user) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		
		if(pattern.matcher(user.getMail()).find() ) {
			return true;
			
		}else {
			System.out.println("Ge�ersiz Email adresi.. ");
			return false;
		}
		
		
	}

	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().length() > 5) {
			return true;
		}else {
			System.out.println("Ge�ersiz Paralo (En az 6 karakter olmal�)");
			return false;
		}
		
	}

	@Override
	public boolean checkMailData(User user, UserDao userDao) {
		List<User> data = userDao.getAll();
		for (User user2 : data) {
			if (user2.getMail() == user.getMail()) {
				System.out.println("Mail adresi sisteme daha �nce kay�tl�. " +user2.getMail().toString() );
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean check() {
		//onaylamak i�in gerekli i�lemler farkl� olabilir basit bir simulasyon olu�turdum.
		Scanner input = new Scanner(System.in);
		System.out.println("Kayd�n�z� tamamlamak i�in 'EVET' yaz�n�z!" );
		String onay = input.nextLine();
		if(onay.equals("EVET")) {
			return true;
		}else {
			System.out.println("Kay�t onaylanmad� !");
			return false;
		}
		
	}

	

}
