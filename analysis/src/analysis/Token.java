package analysis;

import java.io.File;
import java.io.FileReader;

public class Token {
	private static String string;
	private static String str;
	private static char ch;
	/*
	 * ��ȡ�ļ�
	 */
	public static void getChar() throws Exception{		
		File f= new File("D:\\","1.txt");
		if(!f.exists()){
			System.out.println("�ļ������ڣ���������ȷ���ļ�·��");
		}
		FileReader fr = new FileReader(f);
		int rs = 0;
		char[] data = new char[256];
		System.out.print("");
		
		while((rs = fr.read(data)) > 0){
			string = new String(data,0,rs).trim();
		}
	}
	/*
	 *  �ж϶�����ַ��Ƿ�Ϊ��ĸ
	 */
	public static boolean isLetter(char c){
		if((ch >= 'a' && ch <= 'z') || (ch >+ 'A' && ch <= 'Z')){
			return true;
		}
		else
			return false;
	}
	/*
	 * �ж϶�����ַ��Ƿ�Ϊ����
	 */
	public static boolean isDigit(char c){
		if(ch >='0' && ch <= '9'){
			return true;
		}
		else
			return false;
	}
	/*
	 * �ж��Ƿ�Ϊ�ؼ���
	 */
	public static boolean isKey(String string) {
		if(string.equals("void") || string.equals("if")|| string .equals("for")|| string.equals("while") 
				|| string.equals("do")|| string.equals("return")|| string.equals("break")
				|| string.equals("main"))
		{
			return true;
		}
		else return false;
	}
	/*
	 * �ж�������ַ���������ʷ���
	 */
	public static void judgement() throws Exception {
		Token.getChar();
		int m = 0;
		string +=' ';
		for(int i = 0;i < string.length();i++){
			switch (m)
			{
			case 0:
				ch = string.charAt(i);
				if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '='
					|| ch == '>' || ch == '<')
				{
					m = 4;
				}
				else if(ch == ',' || ch == ';' || ch == '{' || ch == '}' || ch == '(' || ch == ')')
				{
					m = 5;
				} 
				else if ( isDigit((ch =string.charAt(i)) ) )
				{
					str = "";
					str += ch;
					m = 3;
				} 
				else if ( isLetter(ch =string.charAt(i)) )
				{
					str = "";
					str += ch;
					m = 2;
				}else {}
				break;
				
			case 4:
				i--;
				System.out.println(("( 4 " + "�� " + ch + " �� )"));
				m = 0;
				break;
				
			case 5:
				i --;
				System.out.println(("( 5 " + "�� " + ch + " �� )"));
				m = 0;
				break;

			case 2:
				if (isLetter(ch = string.charAt(i)))
				{
					str += ch;
				}
				else
				{
					if ( isKey(str) )
					{
						System.out.println("( 1 " + "�� " + str + " �� )");
					}else {
						System.out.println(("( 2 " + "�� " + str + " �� )"));
					}
					i--;
					m = 0;
				}
				break;
				
			case 3:
				if (isDigit((ch =string.charAt(i)) ) )
				{
					str += ch;
				}
				else 
				{
					System.out.println(("( 3 " + "�� " + str + " �� )"));
					i --;
					m = 0;
				}
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Token.judgement();
//		System.out.print(b)  
		
	}
}