class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> toVisit = new LinkedList<>();
        Map<Integer, Node> newGraph = new HashMap<>();
        
        Node first = new Node(node.val);
        newGraph.put(node.val, first);
        toVisit.add(node);
        
        while (!toVisit.isEmpty()) {
            Node curOld = toVisit.poll();
            Node curNew = newGraph.get(curOld.val);

            for (Node neighbor : curOld.neighbors) {
                Node newNeighbor = newGraph.get(neighbor.val);
                if (newNeighbor == null) {
                    newNeighbor = new Node(neighbor.val);
                    newGraph.put(neighbor.val, newNeighbor);
                    toVisit.add(neighbor);
                }
                curNew.neighbors.add(newNeighbor);
            }
        }
        
        return first;
    }
}