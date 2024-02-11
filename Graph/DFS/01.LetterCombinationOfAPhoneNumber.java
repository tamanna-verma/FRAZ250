class Solution {
     
      ArrayList<String> ans = new ArrayList<>();
       
    public List<String> letterCombinations(String digits)
    {
        if(digits.length() == 0)    return ans;
        ArrayList<String> graph= new ArrayList<>();
        
         graph.add("");
         graph.add("1");
         graph.add("abc");
         graph.add("def");
         graph.add("ghi");
         graph.add("jkl");
         graph.add("mno");
         graph.add("pqrs");
         graph.add("tuv");
         graph.add("wxyz");
        
        
       StringBuilder curr = new StringBuilder("");
       dfs(graph ,digits , 0, curr);
       return ans;
    }
    public void dfs(ArrayList<String> graph ,String digits , int index , StringBuilder curr){
        if(index==digits.length()) {
            ans.add(curr.toString());
            return;
        }
       
       int number = digits.charAt(index)-'0';
       String str = graph.get(number);
    //    System.out.println(str);

       for(int i=0;i<str.length();i++){
           curr.append(str.charAt(i));
           dfs(graph , digits, index+1 , curr);
           curr.deleteCharAt(curr.length() - 1);
       }

       
        
    }

}
