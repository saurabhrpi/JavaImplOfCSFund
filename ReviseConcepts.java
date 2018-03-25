import  java.util.Arrays;

public class PalindromeChecker{
    
    public boolean isPalindrome(String str)
    {
        int[] ch = new int[128]; 
        str = str.toLowerCase();
        int n = str.length();
        for(int i=0; i < n/2; i++)
        {
            if(str.charAt(i) != ' ')
            {
                ch[str.charAt(i)]++;  
                System.out.println(str.charAt(i));
                System.out.println(ch[str.charAt(i)]);
            }
        }
        
        boolean isMiddle = false;
        
        for(int i = n/2; i < n ; i++)
        {
            if(str.charAt(i) != ' ')
            {
                ch[str.charAt(i)]--;   
                System.out.println(str.charAt(i));
                System.out.println(ch[str.charAt(i)]);
                if(ch[str.charAt(i)] < 0)
                {
                    if(!isMiddle)
                    {
                        isMiddle = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;   
    }
    
    public static void main(String[] args)
    {
        String input = "cocoa";
        PalindromeChecker pc = new PalindromeChecker();
        if(pc.isPalindrome(input))
        {
            System.out.println("It's indeed a palindrome");
        }
        else
        {
            System.out.println("It's not at all a palindrome");
        }
    }
        
}

public class CompressString{
    public String compress(String str)
    {
        int[] ch = new int[128]; //assuming a sorted string
        char prev = str.charAt(0);
        int len = 0;
        int i;
        for(i=0; i<str.length(); i++)
        {
            ch[str.charAt(i)]++;
            if(str.charAt(i) != prev)
            {
                len = len + Integer.toString(ch[str.charAt(i)]).length() + 1;
                //System.out.println(len);
                prev = str.charAt(i);
            }
        }
        
        len = len + Integer.toString(ch[str.charAt(i-1)]).length() + 1;
        
        //System.out.println(len);
        
        if(len >= str.length())
        {
            return "none";
        }
        
        char[] c = new char[len];
        int j = 0;
        for(int k=0; k < ch.length; k++)
        {
            if(ch[k] > 0)
            {
                c[j] = (char)k;
                c[j+1] = (char)(ch[k] + '0');
                //System.out.println(ch[k]);
                j = j + 2;
            }
        }
        
        return new String(c);   
    }
    
    public static void main(String[] args)
    {
        String input = "aaaabcccddd";
        CompressString cs = new CompressString();
        
        if(cs.compress(input) == "none")
        {
            System.out.println("Compressed string is not shorter than the input");
        }
        else
        {
            System.out.println(cs.compress(input));
        }
    }
}
