package reverseBits;
//ac 2015-4-22
//�����ϣ���Ȼ˵��һ���޷������������Ƿ�ת֮��ķ���ֵ����һ���з���λ������(����������з���λ��)
//������ʵ�����ﲻ��Ҫ���Ǵ���maxvalue�������˵�������Ǳߵ�int����ֻ��4���ֽڵ�
public class ReverseBits {

	/**
	 * @param args
	 */
    public static int reverseBits(int n) {
    	String s="";
    	int temp_n=n,len,ans=0;
    	int flag=0;
    	if(n<0){
    		flag=1;
    		temp_n=temp_n+Integer.MAX_VALUE+1;
    	}
    	while(temp_n!=0){
    		int k=temp_n%2;
    		s=s+String.valueOf(k);
    		temp_n/=2;
    	}
    	len=s.length();
    	for(int i=0;i<(31-len);i++){
    		s+="0";
    	}
    	if(flag==1){
    		s+="1";
    	}
    	else{
    		s+="0";
    	}
    	
    	for(int i=0;i<32;i++){
    		ans=ans*2+Integer.parseInt(s.charAt(i)+"");
    	}
    	
        return ans;


    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=-2;
		System.out.println(reverseBits(s));
	}

}
