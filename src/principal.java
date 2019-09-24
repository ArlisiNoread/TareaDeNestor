import java.util.Scanner;
import java.util.StringTokenizer;

public class principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String linea = scan.nextLine().trim();
		int[] T = new int[2];

		if (linea.contains(" ")) {
			StringTokenizer st = new StringTokenizer(linea);
			T[0] = Integer.parseInt(st.nextToken());
			T[1] = Integer.parseInt(st.nextToken());

			if (!(1 <= T[0] && T[0] <= 50) && !(1 <= T[1] && T[1] <= 50)) {
				return;
			}
		} else {
			return;
		}

		char[][] casos = new char[T[0]][T[1]];

		for (int i = 0; i < T[0]; i++) {
			String fila = scan.nextLine();
			for (int j = 0; j < T[1]; j++) {
				casos[i][j] = fila.charAt(j);
			}
		}

		encuentraCuadrados(casos);
	}

	public static void encuentraCuadrados(char[][] jardin) {
		int cnt = 0;

		for (int i = 0; i < jardin.length - 1; i++) {
			for (int j = 0; j < jardin.length - 1; j++) {
				char comparador = jardin[i][j];

				for (int k = 1; k <= jardin.length - j; k++) {					
					if(i+k < jardin[0].length && j+k < jardin.length) {
						if (jardin[i + k][j + k] == comparador) {
							if (jardin[i][j + k] == comparador) {
								if (jardin[i + k][j] == comparador) {
									cnt++;
								}
							}
						}	
					}
				}
			}
		}

		System.out.println(cnt);
	}

}
