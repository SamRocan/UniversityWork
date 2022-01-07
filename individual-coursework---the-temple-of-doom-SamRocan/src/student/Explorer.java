package student;

import game.*;

import java.util.Arrays;
import java.util.*;

public class Explorer {

  /**
   * Explore the cavern, trying to find the orb in as few steps as possible.
   * Once you find the orb, you must return from the function in order to pick
   * it up. If you continue to move after finding the orb rather
   * than returning, it will not count.
   * If you return from this function while not standing on top of the orb,
   * it will count as a failure.
   * <p>
   * There is no limit to how many steps you can take, but you will receive
   * a score bonus multiplier for finding the orb in fewer steps.
   * <p>
   * At every step, you only know your current tile's ID and the ID of all
   * open neighbor tiles, as well as the distance to the orb at each of these tiles
   * (ignoring walls and obstacles).
   * <p>
   * To get information about the current state, use functions
   * getCurrentLocation(),
   * getNeighbours(), and
   * getDistanceToTarget()
   * in ExplorationState.
   * You know you are standing on the orb when getDistanceToTarget() is 0.
   * <p>
   * Use function moveTo(long id) in ExplorationState to move to a neighboring
   * tile by its ID. Doing this will change state to reflect your new position.
   * <p>
   * A suggested first implementation that will always find the orb, but likely won't
   * receive a large bonus multiplier, is a depth-first search.
   *
   * @param state the information available at the current state
   */
  public void explore(ExplorationState state) {
    // Initialize all variables required to navigate the map
    Stack<Long> thePath = new Stack<>(); //Keeps track of locations traveled
    Set <Long> theLocation = new HashSet<>(); //Keeps track of all locations you are at
    thePath.add(state.getCurrentLocation());
    while(state.getDistanceToTarget() > 0){

      //all possible moves
      List <NodeStatus> neighbours =  new ArrayList<>(state.getNeighbours());

      if (!theLocation.contains(state.getCurrentLocation())){
        theLocation.add(state.getCurrentLocation());
      }
      List<NodeStatus> unvisited = new ArrayList<>();
      for (NodeStatus n: neighbours){
        if (!theLocation.contains(n.nodeID())){
          unvisited.add(n);
        }
      }
      // Check the distance to the orb
      // If you still have further to go, then continue to move
      // to next position
      if(unvisited.size() > 0){
        NodeStatus nextPos;
        nextPos = unvisited.get(0);
        for (NodeStatus i: unvisited){
          if(i.distanceToTarget() < nextPos.distanceToTarget()){
            nextPos = i;
          }
        }
        //Then move and add new position!!
        state.moveTo(nextPos.nodeID());
        thePath.add(nextPos.nodeID());
      }else{
        //Otherwise Back up position if stuck
        thePath.pop();
        state.moveTo(thePath.peek());
      }
    }
  }

  /**
   * Escape from the cavern before the ceiling collapses, trying to collect as much
   * gold as possible along the way. Your solution must ALWAYS escape before time runs
   * out, and this should be prioritized above collecting gold.
   * <p>
   * You now have access to the entire underlying graph, which can be accessed through EscapeState.
   * getCurrentNode() and getExit() will return you Node objects of interest, and getVertices()
   * will return a collection of all nodes on the graph.
   * <p>
   * Note that time is measured entirely in the number of steps taken, and for each step
   * the time remaining is decremented by the weight of the edge taken. You can use
   * getTimeRemaining() to get the time still remaining, pickUpGold() to pick up any gold
   * on your current tile (this will fail if no such gold exists), and moveTo() to move
   * to a destination node adjacent to your current node.
   * <p>
   * You must return from this function while standing at the exit. Failing to do so before time
   * runs out or returning from the wrong location will be considered a failed run.
   * <p>
   * You will always have enough time to escape using the shortest path from the starting
   * position to the exit, although this will not collect much gold.
   *
   * @param state the information available at the current state
   */
  public void escape(EscapeState state) {

      List<Node> thePath;
      //Find the shortest path
      thePath = sortingAlgorithm(state);
      Collections.reverse(thePath);

      while (state.getCurrentNode() != state.getExit()){
        for (Node position: thePath) {
          //To pick up gold as you go
          if(state.getCurrentNode().getTile().getGold() > 0){
            state.pickUpGold();
          }
          //Move to next position
          if(position != state.getCurrentNode()){
            state.moveTo(position);
          }
        }
      }
    }

  /**
   * Sorting algorithm that organises the route out of
   * the Maze
   * @param state the information available at the current state
   * @return the Route out of the Maze
   **/
  public static List<Node> sortingAlgorithm(EscapeState state){
    //Initialize Lists needed for the algorithm to function
    LinkedList<Node> nodeList = new LinkedList<>();
    Set<Node> nodesVisited = new HashSet<>();
    LinkedHashMap<Node, Integer> distanceToExit = new LinkedHashMap<>(state.getVertices().size());
    LinkedHashMap<Node, Node> parentNode = new LinkedHashMap<>(state.getVertices().size());
    nodeList.add(state.getCurrentNode());

    //All distances are set to the maximum value and the initial distance is set to 0.
    //To allow the algorithm to function properly
    for (Node n: state.getVertices()){
      distanceToExit.put(n, Integer.MAX_VALUE);
    }
    distanceToExit.put(state.getCurrentNode(), 0);

    //While the queue isn't empty it sorts through to find the shortest route
    while (!nodeList.isEmpty()){
      Node a = nodeList.pop();
      nodesVisited.add(a);
      Set<Edge> outgoingEdges = new HashSet<>(a.getExits());
      List<Edge> edgesByLength = new ArrayList<>();

      for (Edge e: outgoingEdges) {
        if(!nodesVisited.contains(e.getOther(a))){
          edgesByLength.add(e);
        }
      }
      edgesByLength = helperAlgorithm(edgesByLength);
      for (Edge e: edgesByLength) {
        if(distanceToExit.get(a) + e.length() < distanceToExit.get(e.getOther(a))){
          distanceToExit.put(e.getOther(a), distanceToExit.get(a) + e.length());
          parentNode.put(e.getOther(a), a);
          nodeList.add(e.getOther(a));
        }
      }
    }

    //RouteOut is the made giving the path for to  exit the Maze
    int routeOut = distanceToExit.get(state.getExit());
    List<Node> retRouteOut = new ArrayList<>();
    Node childNode = state.getExit();
    retRouteOut.add(childNode);

    while (!retRouteOut.contains(state.getCurrentNode())){
      childNode = parentNode.get(childNode);
      retRouteOut.add(childNode);
    }

    return retRouteOut;
  }
  /**
   * Algorithm to sort the list in the correct order assisting
   * the main sorting Algorithm
   * @param list Edges by Length sent from the sorting algorithm
   * @return the sorted list
   **/
  public static List<Edge> helperAlgorithm(List<Edge> list){
    for (int i = 0; i < list.size() - 1 ; i++) {
      for (int z = 0; z < list.size() - i - 1 ; z++) {
        if(list.get(z).length > list.get(z + 1).length){
          Edge x = list.get(z);
          list.set(z, list.get(z + 1));
          list.set(z + 1, x);
        }
      }
    }
    return list;
  }

}
