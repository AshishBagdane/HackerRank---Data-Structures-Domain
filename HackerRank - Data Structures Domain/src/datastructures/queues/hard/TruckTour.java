package datastructures.queues.hard;

import java.util.Scanner;

public class TruckTour {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		PetrolPump[] petrolPumps = new PetrolPump[N];

		for (int i = 0; i < N; i++) {
			int capacity = sc.nextInt();
			int distance = sc.nextInt();
			petrolPumps[i] = new PetrolPump(capacity, distance);
		}

		System.out.println(getStartStation(petrolPumps));
		sc.close();
	}

	static class PetrolPump {

		int capacity;
		int distance;

		public PetrolPump() {
		}

		public PetrolPump(int capacity, int distance) {
			this.capacity = capacity;
			this.distance = distance;
		}
	}

	static int getStartStation(PetrolPump[] petrolPumps) {
		int startStation = 0, endStation = 1;
		int availablePetrol = petrolPumps[startStation].capacity - petrolPumps[startStation].distance;

		while (startStation != endStation) {
			if (availablePetrol < 0) {
				startStation = (startStation + 1) % petrolPumps.length;
				if (startStation == 0) {
					return -1;
				}
				endStation = (startStation + 1) % petrolPumps.length;
				availablePetrol = petrolPumps[startStation].capacity - petrolPumps[startStation].distance;
			} else {
				availablePetrol += (petrolPumps[endStation].capacity - petrolPumps[endStation].distance);
				endStation = (endStation + 1) % petrolPumps.length;
			}
		}

		return startStation;
	}
}
