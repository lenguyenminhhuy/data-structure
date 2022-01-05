public class Search2DArray{
    // all integers in each row are sorted in ascending order
    public static boolean search2DArray(int[][] matrix, int target){
        int row = 0; // initial row variable
        int col = matrix[row].length - 1;
        while (row>=0 && row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] < target){
                row++;
            }
            else if (matrix[row][col] > target){
                col--;
            }
        }
        return false;
    }
    public static void main(String[] args){
    System.out.println("Search2DArray");
    // test case 1
    int[][] testArray = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
    int target = 13;

    // test case 2
    int[][] testArr2 = {{1}};
    int target2 = 0;
    search2DArray(testArray, target);
    search2DArray(testArr2, target2);
    }
}
