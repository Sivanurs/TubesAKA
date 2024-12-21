import java.util.Random;
import java.util.Scanner;

public class RandomArray{

    // Metode Iteratif untuk menghitung rata-rata
    public static double rataRataIteratif(int[] penontonPerMinggu) {
        int total = 0;
        for (int penonton : penontonPerMinggu) {
            total += penonton;
        }
        return (double) total / penontonPerMinggu.length;
    }

    // Metode Rekursif untuk menghitung rata-rata
    public static double rataRataRekursif(int[] penontonPerMinggu, int n, int total) {
        if (n == 0) { // Basis rekursi
            return (double) total / penontonPerMinggu.length;
        }
        return rataRataRekursif(penontonPerMinggu, n - 1, total + penontonPerMinggu[n - 1]);
    }

    // Fungsi merge untuk algoritma Merge Sort
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Fungsi rekursif Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    // Fungsi untuk menghasilkan array acak
    public static int[] generateRandomArray(int length, int max) {
        Random random = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(max + 1); // Angka acak dari 0 hingga max
        }
        return randomArray;
    }

    // Fungsi untuk melakukan pengujian antara metode iteratif dan rekursif
    public static void testMethods(int length, int max) {
        // Generate array acak
        int[] penontonPerMinggu = generateRandomArray(length, max);

        // Tampilkan array asli
        System.out.println("Array asli:");
        for (int num : penontonPerMinggu) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Urutkan array menggunakan Merge Sort
        mergeSort(penontonPerMinggu, 0, penontonPerMinggu.length - 1);

        // Tampilkan array setelah diurutkan
        System.out.println("Array setelah diurutkan:");
        for (int num : penontonPerMinggu) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Hitung rata-rata menggunakan metode iteratif
        long startIteratif = System.nanoTime();
        double rataIteratif = rataRataIteratif(penontonPerMinggu);
        long endIteratif = System.nanoTime();
        System.out.println("Rata-rata jumlah penonton (Iteratif): " + rataIteratif);
        System.out.println("Waktu eksekusi metode Iteratif: " + (endIteratif - startIteratif) + " ns");

        // Hitung rata-rata menggunakan metode rekursif
        long startRekursif = System.nanoTime();
        double rataRekursif = rataRataRekursif(penontonPerMinggu, penontonPerMinggu.length, 0);
        long endRekursif = System.nanoTime();
        System.out.println("Rata-rata jumlah penonton (Rekursif): " + rataRekursif);
        System.out.println("Waktu eksekusi metode Rekursif: " + (endRekursif - startRekursif) + " ns");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan panjang array (jumlah minggu): ");
        int length = scanner.nextInt();

        System.out.print("Masukkan nilai maksimum untuk jumlah penonton: ");
        int max = scanner.nextInt();

        // Lakukan pengujian
        testMethods(length, max);

        scanner.close();
    }
}
