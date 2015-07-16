package atoi;
//complete
//2015-02-10-17:40
public class Atoi {

	/**
	 * @param args
	 */
	public static int atoi(String str){
/*        int ans=0,begin=0,end;
        str=str.trim();
        if(str.equals("")){
            return 0;
        }
        while(begin<str.length()){
        	if(str.charAt(begin)<'0'||str.charAt(begin)>'9'){
        		begin++;
        		continue;
        	}
        	break;
        }
        if(begin>1)	return 0;
        
        end=begin;
        while(end<str.length()){
        	if(str.charAt(end)>='0'&&str.charAt(end)<='9'){
        		end++;
        		continue;
        	}
        	break;
        }
//        ans=Integer.parseInt(str.substring(begin,end));
        if(end-begin==10){
        	
        	String temp;
        	temp=str.substring(begin,end-1);
        	if(Integer.parseInt(temp)>Integer.MAX_VALUE/10){
        		return Integer.MAX_VALUE;
        	}
        	else if(Integer.parseInt(temp)==Integer.MAX_VALUE/10){
        		if(str.charAt(9)>'7')
        			return Integer.MAX_VALUE;
        	}
        	
        }
        ans=Integer.parseInt(str.substring(begin,end));
        System.out.println(ans);
        return ans;*/
		//上段为自己所写
		//下段为根据discuss代码所写
		boolean flag=true;
		int begin=0,end,temp;
		long ans=0;
		str=str.trim();
		if(str.equals("")){
			return 0;
		}
		if(str.charAt(0)=='-'){
			flag=false;
			begin++;
		}
		if(str.charAt(0)=='+'){
			begin++;
		}
		while(begin<str.length()){
			if(str.charAt(begin)<'0'||str.charAt(begin)>'9'){
				break;
			}
			ans=ans*10+(int)str.charAt(begin)-'0';
			if(ans>0x7fffffff){
				if(flag)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			}	
			begin++;
		}
		
		if(flag){
			return (int) ans;
		}
		else
			return (int) (ans*-1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(atoi("-9223372036854775809"));
	}

}
