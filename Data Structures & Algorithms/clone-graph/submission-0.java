/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private HashMap<Node,Node> seen = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        return createCopy(node);    
    }

    private Node createCopy(Node node){

        if(seen.containsKey(node)){
            return seen.get(node);
        }

        Node newNode = new Node(node.val);

        seen.put(node,newNode);

        for(var neighbor : node.neighbors){
            newNode.neighbors.add(createCopy(neighbor));
        }

        return newNode;

    }
}