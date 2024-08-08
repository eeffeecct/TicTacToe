import java.util.Scanner;

public class TicTacToe {
    static Scanner sc;

    static char[][] map;
    static final int MAP_SIZE = 3;

    static final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = 'O';

    public static void main(String[] args) {
        init();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_FIELD)) {
                System.out.println("You win!");
                break;
            }
            if (checkDraft()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(O_FIELD)) {
                System.out.println("You lose! ");
                break;
            }
            if (checkDraft()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static boolean checkWin(char playerField) {
        if (map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if (map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
        if (map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;

        if (map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if (map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if (map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

        if (map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if (map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;

        return false;
    }

    public static boolean checkDraft() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= MAP_SIZE || y < 0 || y >= MAP_SIZE) {
            return false;
        }
        return map[y][x] == EMPTY_FIELD;
    }

    public static void aiTurn() {
        int x, y;
        System.out.println("Ход компьютера");
        do {
            System.out.println("Введите координаты X Y : ");
            x = (int) (Math.random() * MAP_SIZE);
            y = (int) (Math.random() * MAP_SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = O_FIELD;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Ход игрока. Введите координаты X Y : ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = X_FIELD;
    }

    public static void printMap() {
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void init() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++){
            for (int j = 0; j < MAP_SIZE; j++){
                map[i][j] = EMPTY_FIELD;
            }
        }
        sc = new Scanner(System.in);
    }
}
