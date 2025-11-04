// class ForDemo {
//     public static void main(String[] args) { 
//         int bilangan[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//         for (int index = 0; index < 10; index++){
//             System.out.println("Count is: " + bilangan[index]);
//         }
//     }
// }

class ForDemo {
    public static void main(String[] args){ 
        int bilangan[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("For loop dengan array.length");
        for (int index = 0; index < bilangan.length; index++) {
            System.out.println("Count is: " + bilangan[index]);
        }
    }
}
