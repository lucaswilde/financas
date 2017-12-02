package uteis;

import controle.GenericDao;

public class LogUtils {

	public static String formatMessage(Class className, String methodName, String message) {
		 return className.getName() + "." + methodName + " = [" + message + "]";
	}
	
	public static String formatMessage(String className, String methodName, String message) {
		 return className + "." + methodName + " = " + message;
	}
	
	public static String formatMessage(String className, String methodName) {
		 return className + "." + methodName;
	}
	
	public static void main(String[] args) {
		System.out.println(LogUtils.formatMessage(GenericDao.class, "rollbackTransaction", null));
	}
}
