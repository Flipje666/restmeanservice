package nl.hu.iac.service;


public class ServiceProvider {
	private static MeanServiceImpl meanService = new MeanServiceImpl();
	public static MeanServiceImpl getMeanService() { return meanService; }
}