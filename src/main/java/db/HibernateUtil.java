package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	/*
	 * static { StandardServiceRegistry standardRegistry; try { standardRegistry =
	 * new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
	 * } catch (Throwable ex) { throw new ExceptionInInitializerError(ex); }
	 * Metadata metaData; try { metaData = new
	 * MetadataSources(standardRegistry).getMetadataBuilder().build(); } catch
	 * (Throwable ex) { throw new ExceptionInInitializerError(ex); } try {
	 * sessionFactory = metaData.getSessionFactoryBuilder().build(); } catch
	 * (Throwable ex) { throw new ExceptionInInitializerError(ex); } }
	 */

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
