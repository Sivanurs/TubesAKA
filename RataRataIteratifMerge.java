// Kodingan dengan metode Iteratif dan Merge Sort
import java.util.Scanner;

public class RataRataIteratifMerge{

    // Metode Iteratif untuk menghitung rata-rata
    public static double rataRataIteratif(int[] penontonPerMinggu) {
        int total = 0;
        for (int penonton : penontonPerMinggu) {
            total += penonton;
        }
        return (double) total / penontonPerMinggu.length;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array untuk menyimpan data penonton per minggu
        int[] penontonPerMinggu = new int[4];

        // Input data penonton per minggu
        for (int minggu = 1; minggu <= 4; minggu++) {
            System.out.print("Masukkan total penonton Minggu " + minggu + ": ");
            penontonPerMinggu[minggu - 1] = scanner.nextInt();
        }

        // Menggunakan Merge Sort untuk mengurutkan jumlah penonton per minggu
        mergeSort(penontonPerMinggu, 0, penontonPerMinggu.length - 1);

        System.out.println("Jumlah penonton per minggu setelah diurutkan:");
        for (int penonton : penontonPerMinggu) {
            System.out.print(penonton + " ");
        }
        System.out.println();

        // Menggunakan metode iteratif untuk menghitung rata-rata
        double rataIteratif = rataRataIteratif(penontonPerMinggu);
        System.out.println("Rata-rata jumlah penonton selama 4 minggu (Iteratif): " + rataIteratif);

        scanner.close();
    }
}
