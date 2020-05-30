package programmers;

import java.util.Hashtable;
//import java.util.Enumeration;

class HashMarathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Hashtable<String,Integer> hs = new Hashtable<>();
        for(String p : participant) hs.put(p, hs.getOrDefault(p,0)+1);
        for(String c : completion) hs.put(c, hs.get(c)-1);
        for(String key : hs.keySet()){
            if(hs.get(key)>0)
                answer+=key;
        }
//         for(int i=0; i<participant.length;i++){
//             if(!hs.containsKey(participant[i])){
//                 hs.put(participant[i],1);
//             }else
//                 hs.put(participant[i],hs.get(participant[i])+1);
            
//         }
//         for(int i=0; i<completion.length;i++){
//             if(hs.containsKey(completion[i])){
//                 hs.put(completion[i],hs.get(completion[i])-1);
//             }
//         }
//         Enumeration<String> keys = hs.keys();
//         while(keys.hasMoreElements()){
//             String key = (String)keys.nextElement();
//             if(hs.get(key)>0)
//                 answer+=key;
//         }
        return answer;
    }
}