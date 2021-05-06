package homeWorkDay5_1;

import homeWorkDay5_1.Entities.concretes.User;
import homeWorkDay5_1.business.abstracts.UserService;
import homeWorkDay5_1.business.concretes.UserManager;
import homeWorkDay5_1.core.concretes.UserCheckManager;
import homeWorkDay5_1.dataAcces.concretes.GoogleUserDao;
import homeWorkDay5_1.dataAcces.concretes.HibernateUserDao;

public class Main {

	public static void main(String[] args) {
		
		UserService userServiceGoogle = new UserManager(new GoogleUserDao(), new UserCheckManager());

		UserService userServiceHibernate = new UserManager(new HibernateUserDao(), new UserCheckManager());
		
		//kullan�c� bilgileri googledan nas�l �ekilir bir fikrim o y�zden elle olu�turuldu.
		
		
		User gecersizAdSoyad = new User(2,"y","sevin�","123456","1yusufsevinc@gmail.com");
		userServiceGoogle.add(gecersizAdSoyad);
		System.out.println("\n");
		
		User yusuf_hibernate = new User(1,"yusuf","sevin�","123456","1yusufsevincHibernate@gmail.com");
		userServiceHibernate.add(yusuf_hibernate);
		System.out.println("\n");
		
		User gecersizSifre = new User(2,"yusuf","sevin�","12345","1yusufsevinc@gmail.com");
		userServiceGoogle.add(gecersizSifre);
		System.out.println("\n");
		
		User gecersizMail = new User(2,"yusuf","sevin�","123456","1yusufsevincgmail.com");
		userServiceGoogle.add(gecersizMail);
		System.out.println("\n");
		
		User yusuf_google = new User(1,"yusuf","sevin�","123456","1yusufsevinc@gmail.com");
		userServiceGoogle.add(yusuf_google);
		System.out.println("\n");
		
		User varOlanMail = new User(2,"yusuf","sevin�","123456","1yusufsevinc@gmail.com");
		userServiceGoogle.add(varOlanMail);
		
		System.out.println("\n");
		System.out.println("\n");
		
		//Giri�
		userServiceGoogle.login(yusuf_google);
		
		userServiceHibernate.login(yusuf_hibernate);
		

	}

}
