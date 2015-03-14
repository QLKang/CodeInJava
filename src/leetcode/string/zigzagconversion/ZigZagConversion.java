package leetcode.string.zigzagconversion;

public class ZigZagConversion {

	public String convert(String s, int nRows) {
		// corner case
	    if(s == null || s.length()==0 || nRows <=0)  
	        return "";  
	    if(nRows == 1)  
	        return s;  
	    StringBuilder res = new StringBuilder();  
	    int size = 2*nRows-2;  
	    for(int i=0;i<nRows;i++)  
	    {  
	        for(int j=i;j<s.length();j+=size)  
	        {  
	            res.append(s.charAt(j));  
	            if(i!=0 && i!=nRows-1 && j+size-2*i<s.length())  
	                res.append(s.charAt(j+size-2*i));  
	        }                  
	    }  
	    return res.toString();  

	}
	
	public String convert2(String s, int nRows) {
        StringBuilder sb = new StringBuilder();

		if (s == null || s == "" || nRows <= 0)
			return "";

        if(nRows==1)
			return s;
			
		int len = s.length();
		for (int i = 0; i < nRows && i < len; i++) {
			for (int k = 0; k < len; k++) {
				// System.out.println("i:"+i+", k:"+k);
				if (i == 0 || i == nRows - 1) {
					if (i + (2 * nRows - 2)*k < len){
				// 		System.out.println(i + (2 * nRows - 2)*k);
						sb.append(s.charAt((i + (2*nRows-2)*k)));
					}
				} else {
					if(k==0)
						sb.append(s.charAt(i));
					if (k!=0 && i + (2*nRows-2)*k - 2*i < len){
				// 		System.out.println(i + (2*nRows-2)*k - 2*i);
						sb.append(s.charAt((i + (2*nRows-2)*k - 2*i)));
					}
					if (k!=0 && i + (2*nRows-2)*k < len){
				// 		System.out.println(i + (2*nRows-2)*k);
						sb.append(s.charAt(i+(2*nRows-2)*k));
					}
				}
			}
		}

		return sb.toString();
    }
	
	
	
} // end class
