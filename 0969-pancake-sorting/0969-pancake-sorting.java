class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;

        for(int i = n - 1; i > 0; i--){
            int maxidx = max(arr, i);

            if(maxidx != i){
                flip(arr, maxidx);
                list.add(maxidx + 1);

                flip(arr, i);
                list.add(i + 1);
            }
        }
        return list;
    }
    public static void flip(int[] arr, int k){
        int left = 0, right = k; 
        while(left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
    public static int max(int[] arr, int n){
        int maxidx = 0;
        for(int i = 0; i <= n; i++){
            if(arr[maxidx] < arr[i]){
                maxidx = i;
            }
        }
        return maxidx;
    }
}