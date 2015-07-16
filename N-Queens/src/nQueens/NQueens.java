package nQueens;
//ac 2015-5-24 
//2015-6-17: 发现这代码好复杂的感觉，当初注释应该写详细一点
//以后可以在来写一遍。现在有些地方不是很理解
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
		//建立一个二维的char数组，类似棋盘，未放置皇后位置放点.代替
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
    //查找下一排可以放置皇后的位置，2代表不可放
    public static int FindLoc(char[][] chr,int row,int after){  				//正常查找到下一个位置
    	
    	for(int i=after;i<chr.length;i++){
    		if(chr[row][i]!='2'){
    			Flag(chr,row,i,'2');
    			return i;
    		}
    	}
    	return -1;
    }
    //总共存在三种状态  1.皇后位置  2.皇后限制的位置  3.已经确认不可行的皇后位置
    public static void Flag(char[][] chr,int row,int column,char flag){  //正常标志皇后位置及其所限制的位置
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
    public static void save(List<String[]> lst,int[] n){      //成功将int坐标转为List
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
    public static void PrintChar(char[][] chr){				//正常输出
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
