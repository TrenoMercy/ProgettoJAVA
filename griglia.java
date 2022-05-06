import java.util.ArrayList;

public class griglia {

    int [][] grill;
    public griglia() {
        grill= new int[7][6];
    }
    public void getGrill() {
        for (int i=0; i<7; i++) {
            for (int j=0; j<6; j++) {
                if (j==5) {
                    System.out.print("| "+grill[i][j]+" |");
                }
                else {
                    System.out.print("| "+grill[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    // valore può essere o 1 o 2
    // inserisce il valore nella colonna indicata
    public void addValue(int col, int valore) {
        int i=6;
        boolean check= false;
        if (col<0 || col>6) {
            System.out.println("Scegli una colonna compresa tra 0 e 6.");
            check=true;
        }
        while (!check) {
            if (grill[i][col]==0) {
                grill[i][col]=valore;
                getGrill();
                System.out.println();
                check=true;
            }
            else if (i==7) {
                System.out.println("La colonna è piena, scegline un'altra.");
                check=true;
            }
            i--;
        }
    }
}