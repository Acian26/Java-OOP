package labs.lab3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /* A reference to the A* algorithm map*/
    private final Map2D map;

    private final HashMap<Location, Waypoint> openHeights = new HashMap<> (); //хэш карта для открытых вершин
    private final HashMap<Location, Waypoint> closeHeights = new HashMap<> (); //хэш карта для закрытых вершин

    /*Class constructor*/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /* Returns the A* algorithm map*/
    public Map2D getMap()
    {
        return map;
    }

    /* Scans through all open waypoints and returns the only with the lowest cost.
    If no waypoints found, returns null */
    public Waypoint getMinOpenWaypoint() { //проверяет все вершины и возвращает ссылку на вершину с min общей стоимостью !
        if (numOpenWaypoints() == 0){
            return null;
        }
        Set<Location> openHeightsKeys = openHeights.keySet();
        Iterator iter = openHeightsKeys.iterator();
        Waypoint best = null;
        float bestCost = Float.MAX_VALUE;
        while (iter.hasNext()){
            Location location = (Location)iter.next();
            Waypoint waypoint = openHeights.get(location);
            float waypointTotalCost = waypoint.getTotalCost();
            if (waypointTotalCost < bestCost){
                best = openHeights.get(location);
                bestCost = waypointTotalCost;
            }
        }
        return best;
    }

    /* Adds or replace a waypoint in the collection if there is no open waypoint at the current location
     * or if old one have bigger cost than the current one*/
    public boolean addOpenWaypoint(Waypoint newWayPoint) //!
    {
        Location location = newWayPoint.getLocation();
        if (openHeights.containsKey(location)) //если есть вершина, то добавить новую если
        {
            Waypoint current_waypoint = openHeights.get(location);
            if (newWayPoint.getPreviousCost() < current_waypoint.getPreviousCost()) //если длина пути через новую вершину короче, чем через старую
            {
                openHeights.put(location, newWayPoint);
                return true;
            }
            return false;
        }
        /* If there is no open waypoints*/
        openHeights.put(location, newWayPoint); //если нет вершин, то просто добавить новую
        return true;
    }


    /* Returns the current number of open waypoints */
    public int numOpenWaypoints() { //возвращает кол-во точек в наборе открытых вершин
        return openHeights.size();
    } //!


    /* Moves a waypoint to the "closed" list*/
    public void closeWaypoint(Location loc) //перемещает из открытых вершин в закрытые !
    {
        Waypoint waypoint = openHeights.remove(loc);
        closeHeights.put(loc, waypoint);
    }

    /* Checks if location is closed*/
    public boolean isLocationClosed(Location loc) //true если указанное местоположение - закрытая вершина !
    {
        return closeHeights.containsKey(loc);
    }
}