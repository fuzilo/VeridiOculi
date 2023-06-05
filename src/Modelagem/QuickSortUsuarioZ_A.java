package Modelagem;
/**
 *
 * @author valmir
 */

import java.util.ArrayList;
import java.util.Collections;

public class QuickSortUsuarioZ_A {
    public void quicksort(ArrayList<Usuario> A) {
        quicksort(A, 0, A.size() - 1);
        Collections.reverse(A);
    }

    private void quicksort(ArrayList<Usuario> A, int inicio, int fim) {
        if (inicio < fim) {
            int q = partition(A, inicio, fim);
            quicksort(A, inicio, q - 1);
            quicksort(A, q + 1, fim);
        }
    }

    private int partition(ArrayList<Usuario> A, int inicio, int fim) {
        Usuario pivo = A.get(inicio);
        int i = inicio;
        int j = fim;

        while (i <= j) {
            while (i <= j && A.get(i).getNome_usuario().compareTo(pivo.getNome_usuario()) <= 0) {
                i++;
            }

            while (i <= j && A.get(j).getNome_usuario().compareTo(pivo.getNome_usuario()) > 0) {
                j--;
            }

            if (i < j) {
                swap(A, i, j);
            }
        }

        swap(A, inicio, j);
        return j;
    }

    private void swap(ArrayList<Usuario> A, int i, int j) {
        Usuario temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}