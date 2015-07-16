package nQueens;
//ac 2015-5-24 
//2015-6-17: ���������ø��ӵĸо�������ע��Ӧ��д��ϸһ��
//�Ժ��������дһ�顣������Щ�ط����Ǻ����
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NQueens {

	/**
	 * @param args
	 */
    public static List<String[]> solveNQueens(int n) {
		List<String[]> lst=new ArrayList<String[]>();
		char[][] chr=new char[n][];
		//����һ����ά��char���飬�������̣�δ���ûʺ�λ�÷ŵ�.����
		for(int i=0;i<chr.length;i++){
			chr[i]=new char[n];
			for(int j=0;j<chr.length;j++){
				chr[i][j]='.';
			}
		}
		int i=0,loc_one;
		int after=0;
		
		int[] loc_array=new int[n];
		while(true){
			loc_one=FindLoc(chr,i,after);
			if(loc_one!=-1){
				loc_array[i]=loc_one;
				after=loc_array[i]+1;
				if(i==n-1){
					save(lst,loc_array);
					continue;
				}
				after=0;
				i++;
				continue;
			}
			else{
				i--;
				if(i<0){
					break;
				}
				SetFlag(chr,loc_array,i);
				after=loc_array[i]+1;
				if(i==0&&after>=n){
					break;
				}
				continue;
			}
		}
		return lst;
		
    }
    //
    public static void SetFlag(char[][] chr,int[] s,int len){
    	for(int i=0;i<s.length;i++){
    		for(int j=0;j<s.length;j++){
    			chr[i][j]='.';
    		}
    	}
    	for(int i=0;i<len;i++){
    		Flag(chr,i,s[i],'2');
    	}
    }
    //������һ�ſ��Է��ûʺ��λ�ã�2�����ɷ�
    public static int FindLoc(char[][] chr,int row,int after){  				//�������ҵ���һ��λ��
    	
    	for(int i=after;i<chr.length;i++){
    		if(chr[row][i]!='2'){
    			Flag(chr,row,i,'2');
    			return i;
    		}
    	}
    	return -1;
    }
    //�ܹ���������״̬  1.�ʺ�λ��  2.�ʺ����Ƶ�λ��  3.�Ѿ�ȷ�ϲ����еĻʺ�λ��
    public static void Flag(char[][] chr,int row,int column,char flag){  //������־�ʺ�λ�ü��������Ƶ�λ��
    	int len=chr.length;
    	for(int i=0;i<len;i++){
    		chr[row][i]=flag;
    		chr[i][column]=flag;
    	}
    	int i=row-Math.min(row, column),j=column-Math.min(row, column);
    	while(true){
    		chr[i][j]=flag;
    		i++;j++;
    		if(i>=len||j>=len){
    			break;
    		}
    	}
    	i=row-Math.min(row, len-column-1);j=column+Math.min(row, len-column-1);
    	while(true){
    		chr[i][j]=flag;
    		i++;j--;
    		if(i>=len||j<0){
    			break;
    		}
    	}
    	chr[row][column]=flag;
    	return ;
    }
    public static void save(List<String[]> lst,int[] n){      //�ɹ���int����תΪList
		int len=n.length;
    	char[][] chr=new char[len][];
		for(int i=0;i<chr.length;i++){
			chr[i]=new char[len];
			for(int j=0;j<chr[i].length;j++){
				chr[i][j]='.';
			}
		}
    	for(int i=0;i<chr.length;i++){
    		chr[i][n[i]]='Q';
    	}
    	String[] str=new String[chr.length];
    	for(int i=0;i<chr.length;i++){
    		str[i]=String.valueOf(chr[i]);
    	}
    	lst.add(str);
    }
    public static void PrintList(List<String[]>lst){
    	for(int i=0;i<lst.size();i++){
    		String[] str=lst.get(i);
    		System.out.print("");
    		for(int j=0;j<str.length;j++){
    			System.out.println("\""+str[j]+"\"");
    		}
    		System.out.println("---------");
    	}
    }
    public static void PrintChar(char[][] chr){				//�������
    	for(int i=0;i<chr.length;i++){
    		for(int j=0;j<chr[i].length;j++){
    			System.out.print(chr[i][j]);
    		}
    		System.out.println();
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1;
		List<String[]> lst=new ArrayList<String[]>();
		lst=solveNQueens(n);
		
		PrintList(lst);
		
	}

}
