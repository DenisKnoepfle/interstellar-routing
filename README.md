# interstellar-routing
Calculates the shortest path from planet "Erde" to planet "b3-r7-r4nd7" in an undirected graph. This project has been motivated by a small coding challenge.

## Graph JSON format
Graph
* nodes (array of `Node`)
* edges (array of `Edge`)

Node
* label (string)

Edge
* source (integer)
* target (integer)
* cost (double)

**Example**
```json
{
  "nodes": [{"label": "Erde"}, {"label": "node_1"}, {"label": "b3-r7-r4nd7"}],
  "edges": [{"source": 0, "target": 1, "cost": 0.8117}, {"source": 2, "target": 1, "cost": 0.5489}]
}
```
**Hint:** The "source" and "target" attributes refer to the corresponding node's index in the nodes array.

## Usage
* Build using `mvn clean package`
* Run `java -jar target/interstellar-routing-1.0.0.jar [json-file]` (default file is "generatedGraph.json")
