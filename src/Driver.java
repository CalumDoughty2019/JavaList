public class Driver {

    private static ListADT<Integer> arrayList = new JavaArrayList<>(3);
    private static ListADT<Integer> dynamicArrayList = new DynamicJavaArrayList<>(3);

    public static void main(String[] args){
        for(int i=0; i<5; i++){
            dynamicArrayList.add(i, i+1);
        }
        System.out.println(dynamicArrayList.size());
    }
}
