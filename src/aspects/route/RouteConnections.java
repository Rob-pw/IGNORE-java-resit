import java.util.List;
import java.util.ArrayList;

public
 class RouteConnections
{ public static
   String list
    ( RouteElement fromSettlement
    , List<? extends RouteElement> segments
    , RouteElement toSettlement)
  { List<RouteElement> combined
     = RouteConnections.combine
        ( fromSettlement
        , segments
        , toSettlement)
  ; String connections
     = RouteConnections.stringify
        ( combined)
  ; return connections; }

  public static
   String stringify
    ( List<RouteElement> elements)
  { String combined = ""
  ; int size = elements.size()
  ; for
      ( int index = 0
      ; index < size
      ; index += 1)
    { RouteElement element
       = elements.get(index)
    ; combined += element.name
        + ((index < size - 1)
           ? ","
           : ""); }

    return combined; }

  public static
   List<RouteElement> combine
    ( RouteElement fromSettlement
    , List<? extends RouteElement>
        segments
    , RouteElement toSettlement)
  { List<RouteElement>
     routeElements = new ArrayList<RouteElement>()

  ; routeElements
      . add(fromSettlement)
  ; routeElements
      . addAll(segments)
  ; routeElements
      . add(toSettlement)

  ; return routeElements; } }
