# TeamAI
This project was developed as part of a hackathon challenge, HACKITALL 2024, organized by LSAC, UPB which focused on optimizing in-store picking processes for the MegaImage supermarket chain. The goal was to create innovative solutions that improve the efficiency and accuracy of picking items from store shelves for customer orders, leveraging technology and streamlined workflows.
We implemented Dijkstra's algorithm, where nodes represent store aisles, to determine the shortest path for picking products from customer orders.
A user-friendly graphical interface was built using Java and JavaFX to assist employees in navigating the store efficiently, minimizing travel time and enhancing order preparation speed.
The solution is designed to be scalable and adaptable to any store layout or planogram, making it suitable for a wide range of supermarket configurations.

# Technologies Used:

Java, JavaFX

# DEMO

The graphical interface consists of two main sections:

Starting Point: The first text field (Raionul 0) represents the current location of the employee in the store (e.g., the starting shelf or department).

Optimal Route: The second section (Ruta optima) displays step-by-step directions, guiding the employee through the shortest path to reach a specific product. Each step indicates the direction to take (e.g., "straight" or "left") and the next shelf or department to visit.

<div align="center">
  <img src="https://github.com/user-attachments/assets/a14c72ca-45c0-4c46-8062-e79a47b53b5e" alt="Demo Image" width="400">
</div>

# Explaining the method

First, we created a graph with "n" aisles in a store and nrProduse represents the number of items ordered by the customer. Then, we sorted the items from the nearest item to the farthest.
```
int n = 7;
graph = new ArrayList[n];
nrProduse = targets.size();
Collections.sort(targets);
for (int i = 0; i < n; i++) {
    graph[i] = new ArrayList<>();
}
```
targets represent the aisles where the items are, in this case, aisles 3,2,6 and 4.
```
private ArrayList<Integer> targets = new ArrayList<>(Arrays.asList(3,2,6,4));
```
The edge class is the connections between aisles, and the weight represents how far away are two aisles from each other. In most supermarkets the aisles have the same distance between them
but we choose to also put weights to allow flexibility for every planogram a store may want to implement. The direction is relative from an aisle to another, we use this variable to be able
to give directions relative to the place where the employee is at a given moment.
```
static class Edge {
        int source, destination, weight ;
        String direction;
        public Edge(int source, int destination, int weight, String direction) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.direction = direction;
        }
    }
```
This is the base function of the application, which is iterated for as many times as the number of items in the order of the client. 
Firstly, the start will be a default place in the store such as "Raion 0" and the target,the first item. Then, the start will be 
replaced with the aisle of the first item, and the target will be the second item, etc until there are no more items left to get.
```
public static List<String> dijkstraWithDirections(List<Edge>[] graph, int start, int target, ArrayList<Integer> targets)
```
Additional function to reconstruct the path made to a certain item
```
private static List<String> reconstructPathWithDirections(int[] previous, String[] directionToNode, int target)
```
The following lines are the aisles created for a specific supermarket, respectively the planogram. An improvement to this project can be
integrating a database to store the planogram, for easy accessibility for any changes regarding aisles, promotions, etc.
```
graph[Categorie.LACTATE.ordinal()].add(new Edge(0, 1, 2, "straight"));
graph[Categorie.CARNURI.ordinal()].add(new Edge(1, 0, 2, "back"));
```

# Thank you for reading me! Hope you like the project:)
