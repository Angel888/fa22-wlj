package littlt_test;

public class tt {
    private Integer itemsL =5;
    public int minusOne(int index){
        // Math.floorMod 保证索引在合法范围内
        return Math.floorMod(index-1,itemsL);
    }

    /* get the next index */
    public int plusOne(int index){
        return Math.floorMod(index+1, itemsL);
    }
    public static void main(String[] args) {
        tt t=new tt();
        System.out.println(t.minusOne(5));
        System.out.println(t.plusOne(6));

    }
}

