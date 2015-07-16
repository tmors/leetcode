package excelSheetColumnNumber;
//ac 2015-4-16
public class ExcelSheetColumnNumber {

	/**
	 * @param args
	 */
	public static int ExcelSheetColumnNumber(String s){
		int i=0;
		if(s.equals("")||s==null){
			return 0;
		}
		for(int j=0;j<=s.length()-1;j++){
			i=i*26+(s.charAt(j)-64);
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		System.out.println(ExcelSheetColumnNumber(str));
	}

}
