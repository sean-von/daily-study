package com.smikevon.basic.interview;

public class TestStringReverse {

	public static void main(String[] args) {
		String str = "abcdefghijklmn";
		System.out.println(reverse(str));

		char[] infos = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'};

		System.out.println(reverse(infos,infos.length));

		String abc = "abcd";
		modify(abc);
		System.out.println(abc);
		StringBuffer sb = new StringBuffer("123243535");
		modify(sb);
		System.out.println(sb);

		String s =  "I am glad to see you";

        System.out.println(s);
        String result = ReverseSentence(s,' ');
        System.out.println(result);
	}

	public static String reverse(String str){
		StringBuffer sb = new StringBuffer();
		for(int i=str.length()-1;i>-1;i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	public static String ReverseSentence(String oldStr,char split) {
        oldStr = oldStr + split;
        char s[] = oldStr.toCharArray();
        String result = "";
        String mid = "";
        for(char c : s){
            mid = mid+c;
            if(c == split){
                result = mid+result;
                mid = "";
            }
        }
        return result;
    }

	public static char[] reverse(char[] infos,int n){
		int i=0;
		int j=n-1;
		char tmp;
		while(i<j){
			tmp = infos[i];
			infos[i]=infos[j];
			infos[j]=tmp;
			i++;
			j--;
		}
		return infos;
	}

	public static void modify(String abc){
		abc = "1323";
	}

	public static void modify(StringBuffer sb){
		sb.append("测试");
	}

}
