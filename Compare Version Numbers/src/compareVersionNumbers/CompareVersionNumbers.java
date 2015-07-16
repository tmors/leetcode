package compareVersionNumbers;
//ac 2015-4-19
//it cost me too much time tonight
//i once thought that there is only one point in the string
public class CompareVersionNumbers {

	/**
	 * @param args
	 */
    public static int compareVersion(String version1, String version2) {
        String[] str1=new String[2],str2=new String[2];
        str1=version1.split("\\.");
        str2=version2.split("\\.");
        int i=0;
        for(;i<Math.min(str1.length, str2.length);i++){
        	int temp1=Integer.parseInt(str1[i]),temp2=Integer.parseInt(str2[i]);
        	if(temp1!=temp2){
        		return temp1>temp2?1:-1;
        	}
        }
        if(str1.length!=str2.length){
        	if(str1.length>str2.length){
        		for(;i<str1.length;i++){
        			if(Integer.parseInt(str1[i])!=0){
        				return 1;
        			}
        		}
        	}
        	else{
        		for(;i<str2.length;i++){
        			if(Integer.parseInt(str2[i])!=0){
        				return -1;
        			}
        		}
        	}
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1.1.1",str2="1.1";
		System.out.println(compareVersion(str,str2));
	}

}
