public class OperasiString {
    public static void main(String[] args) {
        String sentence = "Selamat Datang di PENS";

        String upper = sentence.toUpperCase();
        System.out.println("Konversi karakter menjadi huruf kapital : " + upper);

        String lower = sentence.toLowerCase();
        System.out.println("Konversi karakter menjadi huruf kecil   : " + lower);

        int sentenceLength = sentence.length();
        System.out.println("Panjang string : " + sentenceLength);

        int indexPENS = sentence.indexOf("PENS");
        if (indexPENS != -1) {
            System.out.println("Indeks kata 'PENS' ada di : " + indexPENS);
        } else {
            System.out.println("Kata 'PENS' tidak ditemukan.");
        }
    }
}
