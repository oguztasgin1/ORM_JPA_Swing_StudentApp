package com.oguztasgin.utils;

import java.util.Properties;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.oguztasgin.entity.Student;


public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try { // Try - catch' e kendimiz aldık ide bizi zorlamadi.
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dbschool");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "burhan71");
				
				
				settings.put(Environment.HBM2DDL_AUTO, "update"); //create, update
				// Create -> Bir sinifta belirtilen ORM tablolarıni içeriğle beraber siler ve yeniden oluşturulur.
				// Test amaçli çalişmalarda bu şekilde kullanilir.
				
				// Update -> Tablo yoksa olusturur, varsa silmez, İçeriğini günceller.
				
				settings.put(Environment.SHOW_SQL, "true");
				//Hibernate uzerinden VT' ye giden sql komutlarini görmemize yarar, false yaparsak gorunmez.
				
				settings.put(Environment.FORMAT_SQL, "true");
				// Hibernate uzerinden giden sql komutlarin bizlerin anlacağı basitlikte duzenler.
				
				configuration.setProperties(settings); // Yaptıgım ayarlari ekliyorum.
				
				configuration.addAnnotatedClass(Student.class);
				//ORM mapping islemine tabi tutulacak anotasyon iceren siniflari buraya yaziyoruz.
				
				ServiceRegistry serviceRegistry = 
						new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).build();
				
				//SessionFactory Nesnesi uretmek için;
				// -->
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}

}

