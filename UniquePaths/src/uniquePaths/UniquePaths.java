package uniquePaths;
//ac 2015-4-23
public class UniquePaths {

	/**
	 * @param args
	 */
    public static int uniquePaths(int m, int n) {
		int i=0;
		i=cnk(m+n-2,Math.min(m, n)-1);
        return i;
//�����ǵ�һ������������ΪֵΪ����������⣬����û��ͨ��������������������ԭ��
//�һ�����cnk�����д���
//������������cnkʱ�����ݲ������󣬳�����δ����ʱ�п��ܷ������
//������ȳ���ˣ�Ϊ����С�� ��floatǿ��ת��int
//�µ����⣺float���ھ������⣬���������֮�����1
//    	if(m==1||n==1){
//    		return 1;
//    	}
//    	return uniquePaths(m-1,n)+uniquePaths(m,n-1);
//���ϵڶ����������õ��Ƿ��Σ����ǳ�ʱ�ˣ���ʱ������Դ�
//    	int[][] s=new int[m+1][n+1];
//    	s[m][n]=1;
//    	for(int i=m;i>=1;i--){
//    		for(int j=n;j>=1;j--){
//    			if(i==m&&j==n){
//    				s[i][j]=1;
//    				continue;
//    			}
//    			if(i==m){
//    				s[i][j]=s[i][j+1];
//    				continue;
//    			}
//    			if(j==n){
//    				s[i][j]=s[i+1][j];
//    				continue;
//    			}
//    			s[i][j]=s[i+1][j]+s[i][j+1];
//    		}
//    	}
//    	return s[1][1];
 //��̬�滮����ac��,����ʱ���Գ������Ҳ������һ��Ϊʲô����
    }
    public static int cnk(int n,int k){
    	int a=1;
    	float s=1;
    	for(int i=1;i<=k;i++){
    		a=a/i*n;
    		n--;
    	}
    	return a;
    }
    public static int compare(int m,int n){
    	int[][] s=new int[m+1][n+1];
    	s[m][n]=1;
    	for(int i=m;i>=1;i--){
    		for(int j=n;j>=1;j--){
    			if(i==m&&j==n){
    				s[i][j]=1;
    				continue;
    			}
    			if(i==m){
    				s[i][j]=s[i][j+1];
    				continue;
    			}
    			if(j==n){
    				s[i][j]=s[i+1][j];
    				continue;
    			}
    			s[i][j]=s[i+1][j]+s[i][j+1];
    		}
    	}
    	return s[1][1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(5,5));
		System.out.println(compare(19,13));
	}

}
