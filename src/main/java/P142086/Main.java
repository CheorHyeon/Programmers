package P142086;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = (s.solution("banana"));
        int b[] = (s.solution("foobar"));

        for(int i = 0; i<a.length; i++){
            System.out.printf("%d \n", a[i]);
        }

        for(int i = 0; i<b.length; i++){
            System.out.printf("%d \n", b[i]);
        }


    }
}

class Solution {
    public int[] solution(String s) {

        char[] 문자배열변환 = s.toCharArray();
        int[ ] result = new int[문자배열변환.length];

        for(int i=문자배열변환.length-1;i>=0; i--)
        {
            //i번째와 같은 문자 인덱스 저장 리스트 생성
            List<Integer> li = new ArrayList<>();

            for(int j=0;j<=i-1;j++)
            {
                if(문자배열변환[i] == 문자배열변환[j]) {
                    li.add(j);
                }
            }

            if(li.size() ==0)  // 한개도 없을 때
                result[i] = -1;
            else if(li.size() == 1) // 1개가 같다 → 해당 위치와 차이
                result[i] = i - li.get(0);
            else {
                int 최소차이 = i; // 초기화는 임시로 가장 큰 i로
                for(int k = 0; k <li.size(); k++) {
                    if(i-li.get(k) < 최소차이)
                        최소차이 = i-li.get(k);
                }
                result[i] = 최소차이;
            }
        }

        return result;
    }
}