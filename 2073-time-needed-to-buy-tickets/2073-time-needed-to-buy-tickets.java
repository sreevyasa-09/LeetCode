class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            count++;
            int val = q.poll();
            if(arr[val] > 0){
                arr[val]--;
            }
            if(arr[val] == 0 && val == k){
                break;
            }
            if(arr[val] == 0 && val != k){
                continue;
            }
            q.add(val);
        }
         return count;
    }
}