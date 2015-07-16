package validSudoku;
//2015-02-24
//320ms
//i have no words to the method i adopted here
public class ValidSudoku {

	/**
	 * @param args
	 */
	public static boolean isValidSudoku(char[][] board) {
        int hor,ver;
		for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		//do not judge the value when curr value is '.'(empty)
        		if(board[i][j]=='.'){				
        			continue;
        		}
        		hor=i/3;
        		ver=j/3;
        		//if there is a same value in i line
        		for(int k=j+1;k<9;k++){				
        			if(board[i][j]==board[i][k]){
        				return false;
        			}
        		}
        		//if there is a same value in j row
        		for(int l=i+1;l<9;l++){				
        			if(board[i][j]==board[l][j]){
        				return false;
        			}
        		}
        		//whether there is a same value in the small square the i,j belong to
        		for(int squ_x=hor*3;squ_x<hor*3+3;squ_x++){		
        			for(int squ_y=ver*3;squ_y<ver*3+3;squ_y++){
        				if(board[i][j]==board[squ_x][squ_y]){
        					if(i!=squ_x&&j!=squ_y){
        						return false;
        					}
        					
        				}
        			}
        		}
        		
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str={".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] chr = new char[9][9];
		
		for(int i=0;i<9;i++){
			char[] temp=str[i].toCharArray();
			chr[i]=temp;
		}
		System.out.println(isValidSudoku(chr));
		
		
	}

}
