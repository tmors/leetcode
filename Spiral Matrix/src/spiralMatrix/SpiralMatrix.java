package spiralMatrix;
//ac 20150624
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralMatrix {

	/**
	 * @param args
	 */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int direct_x=0,direct_y=1;
        int cur_x=0,cur_y=-1;
        List<Integer> lst=new ArrayList<Integer>();
        if(matrix.length==0){
        	return lst;
        }
        int times=matrix.length*matrix[0].length;
        while(times>0){
    		cur_x=cur_x+direct_x;
    		cur_y=cur_y+direct_y;
        	if(within(cur_x,cur_y,matrix)){
        		lst.add(matrix[cur_x][cur_y]);
        		matrix[cur_x][cur_y]=-9;//����-9Ϊ�Ѿ����ʹ��ˣ���������е㲻�ã���������ڴ�����ͬ��ֵ�Ļ�
        		times--;
        	}
        	else{
        		cur_x=cur_x-direct_x;
        		cur_y=cur_y-direct_y;
        		if(direct_x==0){
					//�в������仯
					if(direct_y==1){
						//��������һ��
						direct_x=1;
						direct_y=0;
						continue;
					}
					if(direct_y==-1){
						//��������һ��
						direct_x=-1;
						direct_y=0;
						continue;
					}
				}
				if(direct_y==0){
					//�в������仯
					if(direct_x==1){
						//�������ƶ�һ��
						direct_x=0;
						direct_y=-1;
						continue;
					}
					if(direct_x==-1){
						//�������ƶ�һ��
						direct_x=0;
						direct_y=1;
						continue;
					}
				}
        	}
        }
        return lst;
    }
    public static boolean within(int cur_x,int cur_y,int[][] gen){
    	//�жϵ�ǰ�����Ƿ�Ϊ��Ч����
    	if(cur_x>=0&&cur_x<gen.length&&cur_y>=0&&cur_y<gen[cur_x].length&&gen[cur_x][cur_y]!=-9){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=new int[][]{{2,5},{8,4},{0,-1}};
		List<Integer> lst=spiralOrder(matrix);
		for(Iterator<Integer> itr=lst.iterator();itr.hasNext();){
			System.out.print(itr.next()+" ");
		}
	}
}
