package excelSheetColumnTitle;
//2015-03-18 197ms
public class ExcelSheetColumnTitle {

	/**
	 * @param args
	 */
	public static String convertToTitle(int n) {
		String str = "";
		while(n!=0){
			n--;
			str=str+(char)('A'+n%26);
			n=n/26;
		}
		return new StringBuffer(str).reverse().toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(1000000001));
	}

}
