/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Pair{
    int id;
    int importance;

    Pair( int id , int importance){
        this.id= id;
        this.importance= importance;
    }
}

class Solution {
    public int getImportance(List<Employee> employees, int id){
       
       //we need the employee object for id = id
       HashMap<Integer, Employee> map = new HashMap<>();
       Queue<Employee> queue = new LinkedList<>();
       for( Employee e : employees){
           map.put(e.id,e);
        if(e.id==id)queue.add(e);
       }
       
       int ans = 0;
       while(!queue.isEmpty()){
           Employee emp = queue.remove();
           int empid = emp.id;
           ans += emp.importance;
           List<Integer> al = emp.subordinates;
           for( int eid : al){
               queue.add(map.get(eid));
           }
       }
       return ans;
    }
}
